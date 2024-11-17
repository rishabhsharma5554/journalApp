package com.rishabhtech.journalApp.controller;

import com.rishabhtech.journalApp.entity.JournalEntry;
import com.rishabhtech.journalApp.service.JournalService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;


import java.util.List;

@RestController
@RequestMapping("/api/v2/")
public class JournalControllerV2 {

    @Autowired
    private JournalService journalService;

    @GetMapping("/journals")
    public List<JournalEntry> getJournalEntry()
    {
        return journalService.getAllJournal();
    }

    @PostMapping("/journals")
    public String createJournal(@RequestBody JournalEntry journalEntry) {
        journalService.saveJournalEntry(journalEntry);
        return "Success";
    }

    @GetMapping("/journals/{journalId}")
    public JournalEntry getJournalById(@PathVariable(name="journalId") ObjectId id)
    {
        return journalService.getJournalById(id);
    }

    @DeleteMapping("/journals/{journalId}")
    public JournalEntry deleteJournalById(@PathVariable(name="journalId") ObjectId id)
    {
        JournalEntry journalEntry = journalService.getJournalById(id);
        journalService.deleteJournal(id);
        return journalEntry;
    }

    @PutMapping("/journals/{journalId}")
    public JournalEntry updateJournalyId(@PathVariable(name="journalId") ObjectId id,@RequestBody JournalEntry journalEntry)
    {
        return journalService.updateJournal(id,journalEntry);
    }
}
