C/C++ Programming
==============
*C makes it easy to shoot yourself in the foot; C++ makes it harder, but when you do it blows your whole leg off (Bjarne Stroustrup)*

![](tech/cpp-programming/images/cpp-timeline.png)

This opinioned document outlines several things to start with programming in C/C++

#### Must read

- [STL tutorial](https://www.tutorialspoint.com/cplusplus/cpp_stl_tutorial.htm)
- [Meta programming](http://www.informit.com/articles/article.aspx?p=2832416): A walk-through C++ metaprogramming and how to achieve more functionality with less effort.
- [Compare-And-Swap](http://preshing.com/20150402/you-can-do-any-kind-of-atomic-read-modify-write-operation/): a synchronization technique with direct supports from CPU
- [Cache line effect](http://igoro.com/archive/gallery-of-processor-cache-effects/)
- [ReadWrite Lock](https://en.wikipedia.org/wiki/Readers%E2%80%93writer_lock), [SeqLock](https://github.com/rigtorp/Seqlock)
- [Zero Copy](https://en.wikipedia.org/wiki/Zero-copy), [Efficient data transfer through zero copy](https://www.ibm.com/developerworks/library/j-zerocopy/index.html)
- [What is a smart pointer and when should I use one?](https://stackoverflow.com/questions/106508/what-is-a-smart-pointer-and-when-should-i-use-one)
- [Lambdas](https://www.fluentcpp.com/2017/01/19/making-code-expressive-lambdas/)
- [Move semantics](https://stackoverflow.com/questions/3106110/what-are-move-semantics)
- [Building Command-Line and Server Applications with Poco](https://pocoproject.org/slides/190-Applications.pdf)
- [Beautiful Native Libraries](http://lucumr.pocoo.org/2013/8/18/beautiful-native-libraries/)
- [Build systems](https://stackoverflow.com/questions/12017580/c-build-systems-what-to-use)
- [Inline functions](http://www.greenend.org.uk/rjk/tech/inline.html)

#### Good to know

- [Let's Build a Simple Database](https://cstack.github.io/db_tutorial/)
- [Hack the virtual memory: the stack, registers and assembly code](https://blog.holbertonschool.com/hack-virtual-memory-stack-registers-assembly-code/)
- [Making a Heap Allocator](https://handmade.network/wiki/2877-tutorial_making_a_heap_allocator)
- [write-a-hash-table](https://github.com/jamesroutley/write-a-hash-table)
- [Learning C with gdb](https://www.recurse.com/blog/5-learning-c-with-gdb)
- [I Do Not Know C](https://kukuruku.co/post/i-do-not-know-c/)
- [Writing Efficient C and C Code Optimization](https://www.codeproject.com/Articles/6154/Writing-Efficient-C-and-C-Code-Optimization)

#### 1. Languages

- [C++ Core Guidelines](http://isocpp.github.io/CppCoreGuidelines/CppCoreGuidelines.html): The C++ Core Guidelines are a set of tried-and-true guidelines, rules, and best practices about coding in C++

#### 2. Libraries 

##### 2.1 Frameworks

- [Poco](https://github.com/pocoproject/poco): Versatile cross-platform C++ libraries with a network/internet focus. "The battery pack for C++."
- [facebook/folly](https://github.com/facebook/folly): An open-source C++ library developed and used at Facebook
- [Boost](https://github.com/boostorg) ⚡️ - A large collection of generic C++ libraries. 

##### 2.2 Algorigthms & data structures

- [libcds](https://github.com/khizmax/libcds): A C++ library of Concurrent Data Structures
- [junction](https://github.com/preshing/junction): Concurrent data structures in C++
- [cameron314/concurrentqueue](https://github.com/cameron314/concurrentqueue): A fast multi-producer, multi-consumer lock-free concurrent queue for C++11
- [cameron314/readerwriterqueue](https://github.com/cameron314/readerwriterqueue): A fast single-producer, single-consumer lock-free queue for C++
- [disruptor](https://github.com/fsaintjacques/disruptor--): disruptor concurency pattern in c++
- [xxHash](http://cyan4973.github.io/xxHash/): Extremely fast hashing algorithm. Comes in 32 and 64-bit varieties

##### 2.3 Testing

- [Catch2](https://github.com/catchorg/Catch2): A modern, C++-native, header-only, test framework for unit-tests, TDD and BDD - using C++11, C++14, C++17 and later
- [google/googletest](https://github.com/google/googletest): Google Test
- [mocking](https://github.com/google/googletest/): The Google C++ mocking framework.

##### 2.4 Database

- [facebook/rocksdb](https://github.com/facebook/rocksdb): A library that provides an embeddable, persistent key-value store for fast storage (A good replacement for sqlite)
- [SimDB](https://github.com/LiveAsynchronousVisualizedArchitecture/simdb): A high performance, shared memory, lock free, cross platform, single file, no dependencies, C++11 key-value store 

##### 2.5 Logging

- [gabime/spdlog](https://github.com/gabime/spdlog):  Super fast, header only, C++ logging library

##### 2.6 Networking

- [libevent](http://libevent.org/)
- [libuv](http://willfaught.com/post/131383132618/libevent-vs-libev-vs-libuv)
- [facebook/libphenom](https://github.com/facebook/libphenom): An eventing framework for building high performance and high scalability systems in C.
- [Qihoo360/evpp](https://github.com/Qihoo360/evpp): A modern C++ network library for developing high performance network services in TCP/UDP/HTTP protocols
- [facebook/proxygen](https://github.com/facebook/proxygen): A collection of C++ HTTP libraries including an easy to use HTTP server
- [facebook/wangle](https://github.com/facebook/wangle): Wangle is a framework providing a set of common client/server abstractions for building services in a consistent, modular, and composable way.
- [grpc](https://github.com/grpc/grpc/blob/master/examples/cpp/cpptutorial.md): An RPC library and framework
- [facebook/fbthrift](https://github.com/facebook/fbthrift): Facebook's branch of Apache Thrift, including a new C++ server.

##### 2.7 Memory managment

- [jemalloc](https://github.com/jemalloc/jemalloc): jemalloc is a general purpose malloc(3) implementation that emphasizes fragmentation avoidance and scalable concurrency support.

##### 2.8 Configuration

- [yaml-cpp](https://github.com/jbeder/yaml-cpp): A YAML configuration parser and emitter in C++

##### 2.9 Others

- [fmtlib/fmt](https://github.com/fmtlib/fmt): A modern formatting library 
- [Conan package manager](https://conan.io/)

#### 3. Tools

- [VsCode](https://code.visualstudio.com/), [How do I set up Visual Studio Code to compile C++ code?](https://stackoverflow.com/questions/30269449/how-do-i-set-up-visual-studio-code-to-compile-c-code), [Simple Solutions: Coding C and C++ with Visual Studio Code](https://www.codeguru.com/cpp/cpp/simple-solutions-coding-c-and-c-with-visual-studio-code.html), [clang-format](http://clang.llvm.org/docs/ClangFormat.html)
- [C++ Development using Visual Studio Code, CMake and LLDB](https://medium.com/audelabs/c-development-using-visual-studio-code-cmake-and-lldb-d0f13d38c563)
- For Cmake-based projects, you may use [CLion](https://www.jetbrains.com/clion/) from JetBrains

![](tech/cpp-programming/images/vscode.png)

#### 4. Books

*C/C++*
- [The C++ Programming Language](books/the-c-programming-language.pdf) (Bjarne Stroustrup) [C++11]
- [Effective Modern C++](books/effective-modern-cpp.pdf) (Scott Meyers) [C++11/14]
- [C++ Concurrency in Action](books/cpp-concurrency-in-action.pdf) (Anthony Williams) [C++11/14/17] - Using the C++ Concurrency Library
- [Modern C++ Design](books/modern-cpp-design.pdf): Generic Programming and Design Patterns Applied

*Linux System*
- [Linux System Programming](books/linux-system-programming.pdf)
- [The Linux Programming Interface: A Linux and UNIX System Programming Handbook](books/The-Linux-programming-interface-a-Linux-and-UNIX-system-programming-handbook.pdf)

#### 5. References

- [Awesome Modern C++](https://github.com/rigtorp/awesome-modern-cpp)
- [Awesome C++](https://github.com/fffaraz/awesome-cpp)
- [Project-based tutorials in C](https://github.com/rby90/Project-Based-Tutorials-in-C)
