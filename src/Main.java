import enums.Gender;
import enums.Genre;
import enums.Language;
import model.Book;
import model.User;
import service.BookService;
import service.UserService;
import service.serviceImpl.BookServiceImpl;
import service.serviceImpl.UserServiceImpl;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // Бардык Id лер уникальный болуш керек. Эгер уникальный болбосо озубуз тузгон UniqueConstraintException класс ыргытсын.
        // User дин email адресси уникальный болуш керек жана @ болуусу керек. Эгер уникальный болбосо UniqueConstraintException класс,
        // @ болбосо озубуз тузгон BadRequestException класс ыргытсын.
        // User дин телефон номери +996 дан башталып 13 символдон турсун. Болбосо BadRequestException класс ыргытсын.
        // Китептин баасы терс сан болбошу керек. Болбосо NegativeNumberException ыргытсын.
        // Китептин чыккан жылы келечек убакыт болбошу керек.Болбосо DateTimeException ыргытсын.
        // Китептин автору бош болбошу керек. Болбосо EmptyStackException ыргытсын.

        BookService bookService = new BookServiceImpl();
        UserService userService = new UserServiceImpl();



        Book book1 = new Book(1L,"Bednyi papa", Genre.DETECTIVE,new BigDecimal(500),"Adilet", Language.ENGLISH,
                LocalDate.ofYearDay(2021,20));
        Book book2 = new Book(2L,"Bednyi papa", Genre.HISTORICAL,new BigDecimal(500),"Adilet", Language.KYRGYZ,
                LocalDate.ofYearDay(2019,20));
        Book book3 = new Book(3L,"Bednyi papa", Genre.FANTASY,new BigDecimal(500),"Adilet", Language.ENGLISH,
                LocalDate.ofYearDay(2020,20));
        Book book4 = new Book(4L,"Bednyi papa", Genre.HISTORICAL,new BigDecimal(500),"Adilet", Language.RUSSIAN,
                LocalDate.ofYearDay(2018,20));
        Book book5 = new Book(5L,"Bednyi papa", Genre.ROMANCE,new BigDecimal(500),"Adilet", Language.KYRGYZ,
                LocalDate.ofYearDay(2017,20));

        List<Book> bookList = new ArrayList<>(List.of(book1,book2,book3,book4,book5));

        User user1 = new User(1L,"Adilet","Ismailov","adiletismailov@mail.ru","+996777070900",
                Gender.MALE,new BigDecimal(1000),bookList);
        User user2 = new User(2L,"Adilet","Ismailov","adiletismailov@mail.ru","+996777070900",
                Gender.FEMALE,new BigDecimal(1000),bookList);
        User user3 = new User(3L,"Adilet","Ismailov","adiletismailov@mail.ru","+996777070900",
                Gender.MALE,new BigDecimal(1000),bookList);
        User user4 = new User(4L,"Adilet","Ismailov","adiletismailov@mail.ru","+996777070900",
                Gender.FEMALE,new BigDecimal(1000),bookList);
        User user5 = new User(5L,"Adilet","Ismailov","adiletismailov@mail.ru","+996777070900",
                Gender.MALE,new BigDecimal(1000),bookList);
        List<User> userList = new ArrayList<>(List.of(user1,user2,user3,user4,user5));


        while (true){
            System.out.print("""
                    ~~~~~~~~~~~~~~~~~~~~~~~~
                    1. Write id:
                    2. Get All Books:
                    3. Get Books By Genre:
                    4. Creat user:
                    5. Find all users:
                    6. SortBooksByPriceInDescendingOrder:
                    7.
                    8.
                    
                    ~~~~~~~~~~~~~~~~~~~~~~~~
                    Write a command:\020""");
            int number = new Scanner(System.in).nextInt();
            switch (number){
                case 1 -> System.out.println(bookService.createBooks(bookList));
                case 2 -> System.out.println(bookService.getAllBooks());
                case 3 -> System.out.println(bookService.getBooksByGenre(new Scanner(System.in).nextLine().toUpperCase()));
                case 4 -> System.out.println(userService.createUser(userList));
                case 5 -> System.out.println(userService.findAllUsers());
                case 6 -> System.out.println(bookService.sortBooksByPriceInDescendingOrder());
            }
        }
    }
}