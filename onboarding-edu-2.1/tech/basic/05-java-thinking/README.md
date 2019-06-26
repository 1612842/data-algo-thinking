Java System Programming
---------------------------

<div style="text-align:center"><img src ="medi/Java-1-Introduction.png" /></div>

# 1. Mục tiêu
- Làm quen với Java
- Nắm cơ bản các thành phần cơ bản trong một service viết bằng Java

# 2. Nội dung

Đối với các nội dung đánh dấu lả `[T]` (Tutorial), làm theo hướng dẫn ở các bài tutorial để nắm vững về chủ đề đó, những kiến thức này sẽ được ứng dụng vào bài tập `[E]` (Excercise)

Đối với các nội dung đánh dấu là `[R]` (Reading), đọc và viết báo cáo về chủ đề đó, nội dung báo cáo phải làm rõ được:
 + What? Cái đang tìm hiểu là gì (khái niệm, nội dung chi tiết)?...
 + Why? Tại sao lại cần cái này?, giúp giải quyết được gì? Ý nghĩa?, mục đích?...
 + How? Sử dụng như thế nào?, Áp dụng như thế nào, ở đâu?, Cách thức nó vận hành?...

## 2.1 Lý thuyết

### 2.1.1 Java 8 `[T]`

Follow tutorial về [Java](https://www.tutorialspoint.com/java/index.htm) để nắm được các khái niệm và syntax của Java. Chú ý những phần sau:  
 - [Numbers](https://www.tutorialspoint.com/java/java_numbers.htm)
 - [Strings](https://www.tutorialspoint.com/java/java_strings.htm)
 - [Arrays](https://www.tutorialspoint.com/java/java_arrays.htm)
 - [Exceptions](https://www.tutorialspoint.com/java/java_exceptions.htm)  
 - [Inner Classes](https://www.tutorialspoint.com/java/java_innerclasses.htm)
 - [Collections](https://www.tutorialspoint.com/java/java_collections.htm)
 - [Generics](https://www.tutorialspoint.com/java/java_generics.htm)
 - [Multithreading](https://www.tutorialspoint.com/java/java_multithreading.htm)
 
Java 8 là một trong những major release của Java với rất nhiều feature mới.  
Follow tutorial về [Java 8](https://www.tutorialspoint.com/java8/index.htm) để nắm được các tính năng mới mà Java 8 mang lại:
 - [Lambda Expressions](https://www.tutorialspoint.com/java8/java8_lambda_expressions.htm)  
 - [Method References](https://www.tutorialspoint.com/java8/java8_method_references.htm) 
 - [Functional Interfaces](https://www.tutorialspoint.com/java8/java8_functional_interfaces.htm)
 - [Default Methods](https://www.tutorialspoint.com/java8/java8_default_methods.htm)
 - [Streams](https://www.tutorialspoint.com/java8/java8_streams.htm)
 - [Optional Class](https://www.tutorialspoint.com/java8/java8_optional_class.htm)
 - [New DateTime API](https://www.tutorialspoint.com/java8/java8_datetime_api.htm)

### 2.1.1 Unit Test/Logging/Performance `[R]`
- Unit test
  + http://www.vogella.com/tutorials/JUnit/article.html
  + https://dev.to/ice_lenor/unit-testing-best-practices-27ec
- Logging: 
  + Phân biệt các khái niệm liên quan tới log level
  + Tham khảo: https://logging.apache.org/log4j/2.x/performance.html + keyword phía trên
- Làm rõ khái niệm về throughput và latency, P99. (ý nghĩa của các thông số này)

### 2.1.2 Threading `[R]`
- Khái niệm Thread, multithreading & concurrency?
- Thread-safety trong Java là gì? Làm sao để đạt được Thread-safety? (tham khảo: [Thread-Safety](https://www.baeldung.com/java-thread-safety))
- Tìm hiểu về Thread Pool, Executors. (tham khảo: [Thread Pool](https://www.baeldung.com/thread-pool-java-and-guava))

### 2.1.3 Networking `[R]`
- Connection pooling ?
- Caching ? Caching với guava, redis: https://www.baeldung.com/guava-cache, https://redis.io/
- Khái niệm cơ bản về protocol trong networking.
  + http
  + websocket
  + gRPC
- SSL/TLS
- RESTful API là gì?

### 2.1.4 Benchmark `[R]`
 - Benchmark ?
 - Các tool hỗ trợ benchmark hệ thống dành cho Java? So sánh ưu, nhược điểm?

### 2.1.5 JVM `[R]`
-  JVM ? How it work ?
-  JRE vs JDK?

# 2.2. Bài tập `[E]`

### 2.2.1 Yêu cầu chức năng  

[Trò chơi Oẳn Tù Tì](https://en.wikipedia.org/wiki/Rock%E2%80%93paper%E2%80%93scissors)  
 - Thiết kế hệ thống cung cấp APIs cho gameplay của trò chơi Oẳn tù tì với máy. Luật chơi như sau:
  + Mỗi 1 game sẽ gồm n lượt chơi (n >= 1)
  + Trong mỗi lượt, server sẽ trả lời là người chơi thắng, thua hay hoà (kèm kết quả KÉO/BÚA/BAO của máy).
  + Nếu kết quả của lượt chơi là thắng hoặc thua, game kết thúc.
  + Nếu kết quả là hoà, phải chơi thêm lượt tiếp theo đến khi có kết quả thắng hoặc thua.
 - User phải thực hiện đăng nhập mới gọi được API và cung cấp API cho user đăng kí tài khoản.
 - Lưu lại lịch sử tất cả các game + lượt chơi của user.
 - Cung cấp API truy vấn lịch sử tất cả game + lượt chơi của user.
 - Cung cấp API liệt kê danh sách 100 user có tỉ lệ thắng cao nhất.

### 2.2.2 Yêu cầu về mặt thiết kế  
 - Sequence diagram cho tất cả các API/function  
 - Tài liệu mô tả architecture của hệ thống  
 - Tài liệu mô tả thiết kế lưu trữ data model của hệ thống  

### 2.2.3 Yêu cầu Kĩ Thuật  
 - Cung cấp API cho cả 2 protocol (tránh code duplication):  
   + HTTP với Json
   + gRPC với Protobuf
 - Sử dụng [JWT](https://jwt.io/) cho phần authentication.
 - Có thể viết 1 web client đơn giản hoặc sử dụng Postman hoặc công cụ bất kì để test API.
 - Viết Unit Test với line coverage 80%.
 - Thực hiện Performance Test cho API sử dụng Locust, JMeter hoặc công cụ tương tự.
 - Ghi log cho tất cả lời gọi tới API. Đối với trường hợp lỗi hệ thống phải log ra được stacktrace và nguyên nhân của lỗi.

## 2.3 Tham khảo thêm  

Principles
 - [SOLID](https://medium.com/@mari_azevedo/s-o-l-i-d-principles-what-are-they-and-why-projects-should-use-them-50b85e4aa8b6)  
 - [DRY and KISS](https://dzone.com/articles/software-design-principles-dry-and-kiss)  

Code Convention
- [Java Code Conventions](https://www.oracle.com/technetwork/java/codeconventions-150003.pdf)

REST API with Spring
- [REST with Spring series](https://www.baeldung.com/rest-with-spring-series)

Non-Blocking IO 
 - [Blocking và non-blocking IO và sự khác nhau](https://medium.com/@copyconstruct/nonblocking-i-o-99948ad7c957)
 - [Benefits of Netty](https://stackoverflow.com/questions/8406914/benefits-of-netty-over-basic-serversocket-server)
 - [Netty Best Practices](http://normanmaurer.me/presentations/2014-facebook-eng-netty/slides.html)
 - [Netty in Action](http://pdf.th7.cn/down/files/1603/Netty%20in%20Action.pdf)  
