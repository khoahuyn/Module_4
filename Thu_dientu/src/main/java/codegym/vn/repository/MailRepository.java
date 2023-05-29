package codegym.vn.repository;

import codegym.vn.model.Mail;

import java.util.List;

public interface MailRepository {
    List<Mail> findAll();
    Mail findID(int id);
    void edit(Mail mail);
}
