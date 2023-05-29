package codegym.vn.service;

import codegym.vn.model.Mail;

import java.util.List;

public interface MailService {
    List<Mail> findAll();
    Mail findID(int id);
    void edit(Mail mail);
}
