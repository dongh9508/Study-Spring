## Study-Notes

### Inversion of Control

  * 의존 관계 주입(Dependency Injection) 이라고도 하며, 어떤 객체가 사용하는 의존 객체를 직접 만들어 사용하는게 아니라, 외부(`IoC Container`)에서 주입 받아 사용하는 방법을 의미.

### Spring IoC Container

  * BeanFactory

  * 애플리케이션 컴포넌트의 중앙 저장소.

  * 빈 설정 소스로부터 빈 정의를 읽어들이고, 빈을 구성하고 제공한다.

### Bean

  * Spring IoC Container가 관리하는 객체.

  * 장점

    * 의존성 관리

    * 스코프

        * 싱글톤 : 하나

        * 프로토타입 : 매번 다른 객체

        * Spring IoC Container에 등록되는 빈들은 기본적으로 싱글톤 스코프로 빈으로 등록 됨.

          * 빈으로 등록 될 때 아무런 어노테이션을 붙이지 않았다면, 그 빈들은 모두 싱글톤 스코프로 빈으로 등록 됨.

    * 라이프 사이클 인터페이스

    * 빈 등록 방법

      * `@Component` 어노테이션과 `@ComponentScan` 어노테이션을 이용한 자동 등록 방법.

        * `@Repository`, `@Service`, `@Controller` 어노테이션을 사용하면, 어노테이션 내부에 `@Component` 어노테이션이 존재하기 때문에 `@SprngBootApplication` 또는 `@ComponentScan` 어노테이션이 사용될 경우, `@Repository`, `@Service`, `@Controller` 어노테이션이 붙은 클래스는 자동으로 Bean으로 등록 된다.

        *  `@SprngBootApplication` 어노테이션 내부에 `@ComponentScan` 어노테이션이 존재해서 `@SprngBootApplication` 어노테이션이 붙은 클래스가 실행 될 경우, `@ComponentScan` 어노테이션의 기능 또한 같이 동작된다.

      * `@Configuration`어노테이션과 `@Bean` 어노테이션을 이용한 수동 등록 방법.

    * 의존성 주입 방법

      * `@Autowired` 어노테이션을 이용하여 의존성 주입을 할 수 있다.

      * 생성자, 세터, 필드를 이용해서 의존성 주입이 가능하다.

### ApplicationContext

  * Spring에서 IoC Container를 구현하는 클래스로써, BeanFactory를 상속받아 구현된다.

    ```java
    @SpringBootApplication
    public class BootApplication {

      @Autowired
      ApplicationContext context;

      // 현재 IoC 컨테이너에 등록된 Bean들의 이름을 출력하는 코드이다.
      // 출력 결과로 현재 등록된 Bean들을 확인할 수 있다.
      // ApplicationContext 클래스를 통해서 IoC 컨테이너에 등록된 Bean들을 관리할 수 있다.
      public static void main(String[] args) {
          String[] beanDefinitionNames = context.getBeanDefinitionNames();
          System.out.println(Arrays.toString(beanDefinitionNames));
      }
    }
    ```

  * BeanFactory

  * 메시지 소스 처리 기능

  * 이벤트 발행 기능

  * 리소스 로딩 기능

### Spring IoC Container의 역할

  * Bean 인스턴스 생성

  * 의존 관계 설정

  * Bean 설정

### ApplicationContext

  * ClassPathXmlApplicationContext(XML)

    * XML 파일로 Bean을 등록할 때, ApplicationContext를 사용하고자 할 때

    ```java
      ApplicationContext context = new ClassPathXmlApplicationContext(XML.xml)
    ```

  * AnnotationConfigApplicationContext(Java)

    * Java 방식으로 Bean을 등록할 때, ApplicationContext를 사용하고자 할 때

    ```java
      ApplicationContext context = new AnnotationConfigApplicationContext(Java.class)
    ```

### Bean 설정

  * Bean 명세서

  * Bean에 대한 정의를 담고 있음.

    * 이름

    * 클래스

    * 스코프

    * 생성자 Argument(Consturctor)

    * 프로젝트(Setter)

    * ...

### ComponentScan

  * 설정 방법

    * XML 설정에서는 context:component-scan

    * Java 설정에서 `@ComponentScan`

      * `@ComponentScan(basePackageClasses = DemoApplication.class)`

        * basePackageClasses 속성을 줄 경우, 속성에 해당하는 클래스가 위치한 곳부터 ComponentScan을 하라는 것을 의미, 모든 클래스에서 `@Component` 어노테이션이 붙어있는 클래스를 찾아서 Bean으로 등록할 것을 의미한다.

  * 특정 패키지 이하의 모든 클래스 중에 `@Component` 어노테이션을 사용한 클래스를 Bean으로 자동으로 등록 해줌.

### @Autowire

  * 필요한 의존 객체의 "타입"에 해당하는 빈을 찾아 주입한다.

  * 모든 Bean들은 Bean으로 등록되어 있으면, `@Autowired` 어노테이션으로 꺼내와서 주입해줄수 있다.

  * `@Autowired`

    * required : 기본 값은 true (따라서 못 찾으면 애플리케이션 구동 실패)

  * 사용할 수 있는 위치

    * 생성자 (스프링 4.3 부터는 생략 가능)

      ```java
      @Service
      public class BookService {

        private final BookRepository bookRepository;

        public BookService(BookRepository bookRepository) {
          this.bookRepository = bookRepository;
        }
      }
      ```

    * Setter

      ```java
      @Service
      public class BookService {

        BookRepository bookRepository;

        @Autowired
        public void setBookRepository(BookRepository bookRepository) {
          this.bookRepository = bookRepository;
        }
      }
      ```

    * Filed

    ```java
      @Service
      public class BookService {
        
        @Autowired
        BookRepository bookRepository;

      }
      ```

  * 경우의 수 

    * 해당 타입의 빈이 없는 경우

    * 해당 타입의 빈이 한 개인 경우

    * 해당 타입의 빈이 여러 개인 경우

      * 빈 이름으로 시도

        * 같은 이름의 빈을 찾으면 해당 빈 사용

        * 같은 이름 못 찾으면 실패

  * 같은 타입의 빈이 여러 개 일 때

    * BookRepository 인터페이스를 구현하는 MyBookRepository 클래스와 DonghunRepository 클래스 두 개의 클래스가 있을 때, BookService는 어떤 BookRepository의 구현체를 주입하는가?

      * BookService 클래스가 다음과 같다고 할 때.

        ```java
        @Service
        public class BookService {

          @Autowired
          BookRepository bookRepository;
        }
        ```

      * 에러가 일어남, 주입을 하지 못한다. 
      
        * MyBookRepository 클래스와 DonghunBookRepository 클래스 중에 어느 레파지토리를 주입해야 하는지 스프링 자체에서 판단하지 못해서 에러가 일어난다.

    * 해결책

      * `@Primary`

        * 둘 중 사용하고자 하는 레파지토리에 `@Primary` 어노테이션을 붙여서 둘 중 어느 레포지토리를 사용할 지에 대해 표기해줄수 있다.

        ```java
        @Service
        public class BookService {

          @Autowired
          BookRepository bookRepository;

          public void printBookRepository() {
            System.out.println(bookRepository.getClass());
          }
        }
        ```

        ```java
        @Repository
        public interface BookRepository {
        }
        ```

        ```java
        @Repository @Primay
        public class DonghunBookRepository implements BookRepository {
        }
        ```
        
        ```java
        @Component
        public class BookServiceRunner implements ApplicationRunner {

          @Autowired
          BookService bookService;

          @Override
          public void run(ApplicationArguments args) throws Exception {
            bookService.printBookRepository();
          }
        }   
        ```

        ```java
        >>> 결과적으로 DonghunBookRepository가 주입되는 것을 볼 수 있다.
        ```

      * `@Qualifier`
        
        ```java
        @Service
        public class BookService {

          @Autowired @Qualifier("donghunBookRepository")
          BookRepository bookRepository;

          public void printBookRepository() {
            System.out.println(bookRepository.getClass());
          }
        }
        ```

        ```java
        @Repository 
        public class DonghunBookRepository implements BookRepository {
        }
        ```
        
        ```java
        @Component
        public class BookServiceRunner implements ApplicationRunner {

          @Autowired
          BookService bookService;

          @Override
          public void run(ApplicationArguments args) throws Exception {
            bookService.printBookRepository();
          }
        }   
        ```

        ```java
        >>> 결과적으로 DonghunBookRepository가 주입되는 것을 볼 수 있다.
        ```

      * 해당 타입의 빈 모두를 주입 받는 방법으로 해결할 수 있다.

        ```java
        @Service
        public class BookService {

          @Autowired 
          List<BookRepository> bookRepositories;

          public void printBookRepository() {
            this.bookRepositories.forEach(System.out::println);
          }
        }
        ```

        ```java
        @Repository 
        public class DonghunBookRepository implements BookRepository {
        }
        ```

        ```java
        @Repository 
        public class MyBookRpeository implements BookRepository {
        }
        ```
        
        ```java
        @Component
        public class BookServiceRunner implements ApplicationRunner {

          @Autowired
          BookService bookService;

          @Override
          public void run(ApplicationArguments args) throws Exception {
            bookService.printBookRepository();
          }
        }   
        ```

        ```java
        >>> DonghunBookRepository 와 MyBookRpeository 둘 다 주입된 것을 볼 수 있다.
        ```
    
    * 가장 추천 방법은 `@Primary` 어노테이션을 사용하는 방법.

      
