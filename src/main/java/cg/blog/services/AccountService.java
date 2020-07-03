package cg.blog.services;

import cg.blog.models.Account;

public interface AccountService {
    Account findAccountByUsername(String username);

}
