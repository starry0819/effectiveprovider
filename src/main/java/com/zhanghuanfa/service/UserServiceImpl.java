package com.zhanghuanfa.service;

import com.zhanghuanfa.model.po.Book;
import com.zhanghuanfa.model.po.User;
import com.zhanghuanfa.repository.UserRepo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Objects;

/**
 * @author zhanghuanfa
 * @date 2018-01-02 20:22
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    @Resource
    private UserRepo userRepo;
    @Resource
    private NewUserService userService2;
    @Resource
    private BookService bookService;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public User getUserById(Integer id) {
        User user = userRepo.getUserById(id);
        user.setPassword("222222");
        int i1 = userService2.updateUser();
        int execute = userRepo.updateUser(user);
        if (Objects.equals(execute, 1)) {
            Book book = Book.builder().id(1).name("西游记").build();
            int i = bookService.updateBook(book);
//            System.out.println(i/0);
        }
        List<Book> allBook = bookService.getAllBook();
        System.out.println(allBook);
        return user;
    }

    @Override
    public void getUserByUserCondition(Integer id) {
        User user = new User();
        user.setId(1);
        List<User> userByUserCondition = userRepo.getUserByUserCondition(user);
        System.out.println(userByUserCondition);
    }

    @Override
    public int updateUser() {
        return 0;
    }
}
