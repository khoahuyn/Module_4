package codegym.vn.service.impl;

import codegym.vn.model.Mail;
import codegym.vn.repository.MailRepository;
import codegym.vn.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MailServiceImpl implements MailService {
    @Autowired
    private MailRepository repository;
    @Override
    public List<Mail> findAll() {
        return repository.findAll();
    }

    @Override
    public Mail findID(int id) {
        return repository.findID(id);
    }

    @Override
    public void edit(Mail mail) {
        repository.edit(mail);
    }
}
