Linux System Programming
==================

<div align="center">
    <img alt="linux" src="media/linux-system-programming.jpg">
</div>

## 1. Mục Tiêu

- Nắm các chủ đề cơ bản của Linux System Programming. (Network, Thread, Memory Management, etc.)
- Nẵm được cơ bản cách hoạt động của các system call trong Linux.
- Biết cách sử dụng công cụ debug, check memory leak trên Linux.

## 2. Kiến thức về Linux System

### 2.1 File và File System

- Linux tuân theo một triết lý đó là: `everything-is-a-file`.

**Yêu cầu**
- Hãy nêu rõ triết lý này bằng cách tìm hiểu ngóc nghách của `file descriptor` trong kernel.
- Tìm hiểu và nêu rõ hai khái niệm `Regular files` và `Special files`.

### 2.4 Process & Thread

#### 2.4.1 Process

**Yêu cầu:**
- Tìm hiểu khái niệm Process trong hệ điều hành.
- Các thành phần trong `Memory Layout` nêu rõ vai trò của từng thành phần, cụ thể: `Stack`, `Heap`, `Data Segment`, `Text Segment`.

### 2.4.2 Thread

**Yêu cầu:**
- Tìm hiểu khái niệm Thread, POSIX Thread, các API trong POSIX.
- Tìm hiểu về Multi-Threading, các vấn đề gặp phải trong multi-threading.
- Làm rõ khái niệm `race condition`, `deadlock`, cách ngăn chặn race condition, deadlock.

### 2.5 Synchronization

**Yêu cầu:**
- Tìm hiểu khái niệm `Semaphore`, so sánh Semaphore với Mutex.
- Tìm hiểu thêm về `Reader Writer Problem`.

### 2.6 Networking

**Yêu cầu**
- Biết sử dụng socket TCP, UDP
- Phân biệt được Nonblocking I/O và Blocking I/O.

## 3. Phần thực hành

### 3.1. Tools

*Tìm hiểu basic phần này để vận dụng vào `3.2` và `3.3`*

**Yêu cầu 1**:
- Biết cách sử dụng debug tool: GDB on Linux
- Tham khảo: 
  - [GDB Tutorial](https://www.tutorialspoint.com/gnu_debugger)
  - [GDB command summary](https://darkdust.net/files/GDB%20Cheat%20Sheet.pdf)

**Yêu cầu 2**:
- Tìm hiểu về makefile
- Viết được makefile cơ bản để compile một chương trình.

  ```sh
  $ make
  $ make clean
  $ make test
  ```

- Tham khảo:
    - [GCC Make](https://www3.ntu.edu.sg/home/ehchua/programming/cpp/gcc_make.html)
    - [CMake](https://cmake.org/cmake-tutorial/)


### 3.2. Linux Command

- Viết chương trình `C` mô phỏng lại command `ls -l`

### 3.3. Trò chơi xếp bi 

**Mục tiêu**

- Biết cách xây dựng TCP Client, TCP Server
- Vận dụng các kiến thức về Linux System ở trên để giải quyết bài toán, cụ thể là về Networking, Thread, Synchronization,...
- Biết cách sử dụng các công cụ debug trong quá trình code.

**Mô tả**

- Vào mùa thu năm 2019, Bill và đồng bọn đã nghĩ ra một trò chơi hết sức kinh dị như sau: Cả bọn xây dựng một cửa hàng cung cấp bi với số lượng và chất lượng (kích thước) có giới hạn. Sau khi xây dựng xong cửa hàng, cả bọn tập trung tại một điểm và chạy đến cửa hàng để lấy ngẫu nhiên một bi về `tổ ` của từng thằng, sau đó sắp xếp theo kích thước tăng dần của các bi. Một thời gian sau, cửa hàng hết bi và cả bọn tìm ra người chiến thắng bằng cách gửi số liệu bi về cho bác bán hàng, bác bán hàng tiến hành tính tính toán toán và thông báo kẻ thắng cuộc.

**Yêu cầu**

- Xây dựng một chương trình (console) với hai thành phần Client (Bill và đồng bọn) và server (Cửa hàng và bác bán hàng). Khi Server start nó khởi tạo ngẫu nhiên một mảng các phần tử số nguyên, với kích thước mảng `ngẫu nhiên` trong khoảng từ 100-1000 phần tử. Các Client mở kết nối đến Server và tiến hành lấy một phần tử trong mảng và ghi vào một file `(tổ)`, file này chứa danh sách các số đã lấy theo thứ tự `tăng dần` (file này ở phía Client nhé). Sau khi Server thông báo mảng đã hết các phần tử, Client tiến hành gửi số liệu đã ghi (file) cho Server, Server tính toán và đưa ra bảng xếp hạng (file) và gửi cho tất cả Client.

- Xây dựng một TCP Server:
    - Lắng nghe và accept kết nối đến từ nhiều Client.
    - Random kích thước mảng và giá trị các phần tử trong mảng.
    - Xử lý logic như yêu cầu trên
- Xây dựng Client:
    - Connect đến Server
    - Request bi và ghi nhận bi vào file
    - Gửi số liệu bi cho Server

**Ràng buộc**

*2 < Số lượng client < 10*
*100 < Kích thước mảng < 1000*
