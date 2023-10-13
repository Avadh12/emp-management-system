package com.example.Employee_Management.model;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class TaskCreateRequest {
    private Integer projectId;
    private String taskDescription;
    public class PrintEvenCharacters {
    public static void main(String[] args) {
        String input = "I love my country";
        printEvenCharacters(input);
    }

    private static void printEvenCharacters(String input) {
        for (int i = 0; i < input.length(); i += 2) {
            char character = input.charAt(i);
            if (character != ' ') {
                System.out.print(character);
            }
        }
    }
}
}
