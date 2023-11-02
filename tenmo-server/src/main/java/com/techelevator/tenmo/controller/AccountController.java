package com.techelevator.tenmo.controller;

import com.techelevator.tenmo.dao.AccountDao;
import com.techelevator.tenmo.dao.TransferDao;
import com.techelevator.tenmo.model.Transfer;
import com.techelevator.tenmo.model.Account;
import org.springframework.web.bind.annotation.*;
import com.techelevator.tenmo.dao.AccountDao;
import java.math.BigDecimal;
import java.util.List;

@RestController
public class AccountController {
    private AccountDao accountDao;
    private TransferDao transferDao;

    public AccountController(AccountDao accountDao, TransferDao transferDao) {
        this.accountDao = accountDao;
        this.transferDao = transferDao;
    }

    @RequestMapping(path = "balance/{id}", method = RequestMethod.GET)
    public BigDecimal getBalance(@PathVariable int id) {
        return accountDao.getBalanceByUserId(id);
    }

    @RequestMapping(path = "transfers", method = RequestMethod.GET)
    public List<Transfer> getAllTransfers() {
        return transferDao.getTransfers();
    }

    @RequestMapping(path = "transfers/{id}", method = RequestMethod.GET)
    public Transfer getTransferById(@PathVariable int transferId) {
        return transferDao.getTransferById(transferId);
    }

    @RequestMapping(path = "transfers/pending", method = RequestMethod.GET)
    public List<Transfer> getPendingTransfers() {
        return transferDao.getPendingTransfers();
    }

    @RequestMapping(path = "transfers/completed", method = RequestMethod.GET)
    public List<Transfer> getCompletedTransfers() {
        return transferDao.getCompletedTransfers();
    }
    @RequestMapping(path = "/accounts", method = RequestMethod.GET)
    public List<Account> getAccounts() {
        return accountDao.getAccounts();
    }

    @RequestMapping(path = "/accounts/{accountId}", method = RequestMethod.GET)
    public Account getAccountByAccountId(@PathVariable int accountId) {
        return accountDao.getAccountByAccountId(accountId);
    }

    @RequestMapping(path = "/accounts/user/{userId}", method = RequestMethod.GET)
    public Account getAccountByUserId(@PathVariable int userId) {
        return accountDao.getAccountByUserId(userId);
    }

    @RequestMapping(path = "/balance/{userId}", method = RequestMethod.GET)
    public BigDecimal getBalanceByUserId(@PathVariable int userId) {
        return accountDao.getBalanceByUserId(userId);
    }
}
