package com.rishabhtech.journalApp.service;

import com.rishabhtech.journalApp.entity.JournalEntry;
import com.rishabhtech.journalApp.repository.JournalRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.time.LocalDateTime;

@Service
public class JournalService {

    @Autowired
    private JournalRepository journalRepository;

    public List<JournalEntry> getAllJournal()
    {
        List<JournalEntry> all = journalRepository.findAll();
        return all;
    }

    public JournalEntry saveJournalEntry(JournalEntry journalEntry)
    {
        journalEntry.setDateTime(LocalDateTime.now());
        return journalRepository.save(journalEntry);
    }
    
    public void deleteJournal(ObjectId id)
    {
        journalRepository.deleteById(id);
    }

    public JournalEntry getJournalById(ObjectId id)
    {
        return journalRepository.findById(id).orElse(null);
    }

    public JournalEntry updateJournal(ObjectId id,JournalEntry newJournalEntry)
    {
        JournalEntry oldJournalEntry = journalRepository.findById(id).orElse(null);
        if(oldJournalEntry != null)
        {
            oldJournalEntry.setDateTime(LocalDateTime.now());
            oldJournalEntry.setTitle(newJournalEntry.getTitle() !=null && !newJournalEntry.getTitle().equals("") ? newJournalEntry.getTitle() : oldJournalEntry.getTitle());
            oldJournalEntry.setContent(newJournalEntry.getContent()!=null && !newJournalEntry.getContent().equals("") ? newJournalEntry.getContent() : oldJournalEntry.getContent());
        }
        return journalRepository.save(oldJournalEntry);

    }

}
