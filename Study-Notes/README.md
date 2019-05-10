## Study-Notes

### Inversion of Control

  * 의존 관계 주입(Dependency Injection) 이라고도 하며, 어떤 객체가 사용하는 의존 객체를 직접 만들어 사용하는게 아니라, 주입 받아 사용하는 방법을 의미.

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

      * `@Component` 어노테이션과 `@ComponentScan` 어노테이션을 이용한 자동 등록 방법

      * `@Configuration`어노테이션과 `@Bean` 어노테이션을 이용한 수동 등록 방법

    * 의존성 주입 방법

      * `@Autowired` 어노테이션을 이용하여 의존성 주입을 할 수 있다.

      * 생성자, 세터, 필드를 이용해서 의존성 주입이 가능하다.

### ApplicationContext

  * BeanFactory

  * 메시지 소스 처리 기능

  * 이벤트 발행 기능

  * 리소스 로딩 기능
