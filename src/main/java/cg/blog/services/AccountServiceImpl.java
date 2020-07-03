package cg.blog.services;

import cg.blog.models.Account;
import cg.blog.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.List;

public class AccountServiceImpl implements AccountService, UserDetailsService {

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public Account findAccountByUsername(String username) {
        return this.accountRepository.findAccountByUsername(username);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Account account = this.findAccountByUsername(username);

        List<GrantedAuthority> roleList = new ArrayList<>();
        roleList.add( new SimpleGrantedAuthority(account.getRole()));

        return new User(account.getUsername(), account.getPassword(), roleList);
    }
}
