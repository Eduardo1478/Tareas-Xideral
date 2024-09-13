package com.example.shopping_cart_rest_api_jpa.batch;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

import com.example.shopping_cart_rest_api_jpa.models.Cart;
import com.example.shopping_cart_rest_api_jpa.repository.CartRepository;

@Configuration
@EnableBatchProcessing
public class BatchConfig {

    @Autowired
    private CartRepository cartRepository;


    @Bean
    public Job salesReportJob(JobRepository jobRepository, PlatformTransactionManager transactionManager) {
        Step step = new StepBuilder("generateSalesReportStep", jobRepository)
            .<Cart, Cart>chunk(10, transactionManager)
            .reader(cartReader())
            .processor(cartProcessor())
            .writer(salesReportWriter())
            .build();

        return new JobBuilder("salesReportJob", jobRepository)
            .start(step)
            .build();
    }

    @Bean
    public ItemReader<Cart> cartReader() {
        return new ItemReader<Cart>() {
            private Iterator<Cart> cartIterator;
    
            @Override
            public Cart read() {
                if (cartIterator == null) {
                    List<Cart> cartList = cartRepository.findAll();
                    cartIterator = cartList.iterator();
                }
    
                if (cartIterator.hasNext()) {
                    return cartIterator.next();
                } else {
                    return null;  // Indicate that the reading is complete
                }
            }
        };
    }
    

    @Bean
    public ItemProcessor<Cart, Cart> cartProcessor() {
        return cart -> {
            double totalSales = cart.getCartItems().stream()
            .mapToDouble(cartItem -> cartItem.getItem().getPrice() * cartItem.getQuantity()) // Access price from Item
                .sum();
            System.out.println("Cart ID: " + cart.getId() + " - Total Sales: " + totalSales);
            return cart; // Optionally, you could enhance this object if needed for writing
        };
    }

    @Bean
    public ItemWriter<Cart> salesReportWriter() {
        return carts -> {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter("sales_report.csv"))) {
                writer.write("Cart ID, Total Sales\n");
                for (Cart cart : carts) {
                    double totalSales = cart.getCartItems().stream()
                        .mapToDouble(cartItem -> cartItem.getItem().getPrice() * cartItem.getQuantity())
                        .sum();
                    writer.write(cart.getId() + "," + totalSales + "\n");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        };
    }

}
