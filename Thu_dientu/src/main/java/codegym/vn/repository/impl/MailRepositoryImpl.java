package codegym.vn.repository.impl;

import codegym.vn.model.Mail;
import codegym.vn.repository.MailRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;


@Repository
public class MailRepositoryImpl implements MailRepository {
    private final static List<Mail> mailList = new ArrayList<>();

    static {
        mailList.add(new Mail(1,"English", 100, "Harry Potter and the sorcerer's stone"));
        mailList.add(new Mail(2,"Vietnamese", 5, "Thần Thor"));
        mailList.add(new Mail(3,"Chinese", 20, "海边的卡夫卡"));

    }

    @Override
    public List<Mail> findAll() {
        return mailList;
    }

    @Override
    public Mail findID(int id) {
        for (Mail mail : mailList) {
            if (mail.getId() == id)
                return mail;
        }
        return null;
    }


    @Override
    public void edit(Mail mail) {
        for(int i = 0; i < mailList.size(); i++) {
            if (mailList.get(i).getId() == mail.getId())
            {
                mailList.get(i).setPageSize(mail.pageSize);
                mailList.get(i).setLanguages(mail.languages);
                mailList.get(i).setSignature(mail.signature);
            }
        }
    }
}
