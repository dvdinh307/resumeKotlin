package com.example.resumeandroid.models.database

//@Singleton
//class UserDataSource @Inject constructor(private val userDao: UserDao) : UserResponseInterface {
//    // Create 4 thread
//    private val executorService: ExecutorService = Executors.newFixedThreadPool(4)
//
//    override val user: LiveData<User> = userDao.getUser()
//
//    override fun insertUser(user: User) {
//        executorService.execute {
//            userDao.insertUser(user)
//        }
//    }
//
//    override fun removeUser() {
//        executorService.execute {
//            userDao.removeUser()
//        }
//    }
//}