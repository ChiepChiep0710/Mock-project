package controller;

import model.Discount;
import service.DiscountService;
import service.impl.DiscountServiceImpl;
import util.DiscountValidator;

import java.util.List;
import java.util.Scanner;

import static java.lang.System.in;
import static java.lang.System.out;

public class DiscountMain {
    private static final DiscountService discountService = new DiscountServiceImpl();
    private static DiscountValidator validator = new DiscountValidator();
    public static void main(String[] args) {
        int choice;
        Scanner s = new Scanner(in);
        do{
            out.println("Choose function: ");
            out.println("1. Add a new Discount");
            out.println("2. Show all Discounts");
            out.println("3. Update Discounts");
            out.println("4. Remove Discount");
            out.println("0. Exit");
            out.println("Please choose: ");
            choice = s.nextInt();
            s.nextLine();
            switch (choice){
                case 1:
                    boolean result = discountService.createDiscount();
                    out.println("CREATE DISCOUNT " + (result ? "SUCCESS" : "FAIL"));
                    break;
                case 2:
                    List<Discount> discounts = discountService.findAllDiscount();
                    out.printf("%-20s%-20s%-20s%-20s%-20s%-20s\n", "ID", "TITLE", "TYPE", "DISCOUNT", "START DATE", "END DATE");
                    for (int i = 0; i < discounts.size(); i++) {
                        out.printf("%-20s%-20s%-20s%-20.2f%-20s%-20s\n", discounts.get(i).getDiscountId(), discounts.get(i).getTitle(), discounts.get(i).getType(), discounts.get(i).getDiscount(), discounts.get(i).getStartDate(), discounts.get(i).getEndDate());
                    }
                    break;
                case 3:
                    out.println("Enter the ID to update:");
                    int id = s.nextInt();
                    boolean res = discountService.updateDiscount(id);
                    out.println("UPDATE DISCOUNT " + (res ? "SUCCESS" : "FAIL"));
                    break;
                case 4:
                    out.println("Enter the ID to delete: ");
                    id = s.nextInt();
                    res = discountService.deleteDiscount(id);
                    out.println("DELETE DISCOUNT " + (res ? "SUCCESS" : "FAIL"));
                    break;
                case 0:
                    out.println("THANK YOU FOR USING THE SERVICE");
                    break;
                default:
                    out.println("PLEASE CHOOSE CORRECT CASE");
                    break;

            }
        }while (choice != 0);
    }
}
