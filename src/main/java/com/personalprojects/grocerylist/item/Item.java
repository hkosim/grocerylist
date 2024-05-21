package com.personalprojects.grocerylist.item;

import com.personalprojects.grocerylist.item.enums.ItemStatus;
import com.personalprojects.grocerylist.item.enums.SupermarketName;
import com.personalprojects.grocerylist.item.enums.Category;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;

import javax.annotation.processing.SupportedSourceVersion;
import java.time.LocalDateTime;

public record Item(
        @Id
        Integer id,
        @NotEmpty
        String name,
        String description,
        @Positive @NotNull
        Integer quantity,
        @NotNull
        Category category,
        @NotNull
        ItemStatus status,
        @NotNull
        SupermarketName supermarketName,

        LocalDateTime purchasedOn,
        @Version
        Integer version
) {

    public Item {
        if(quantity > 999){
            throw new IllegalArgumentException("Too many items!");
        }
    }

}