package com.example.demo;
import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String location;
    private String date;

    @OneToMany(mappedBy = "event", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Participant> participants;
    public String getName()
    {
    	return this.name;
    }
    public String getLocation()
    {
    	return this.location;
    }
    public String getDate()
    {
    	return this.date;
    }
    public void setName(String name)
    {
    	this.name=name;
    }
    public void setLocation(String location)
    {
    	this.location=location;
    }
    public void setDate(String date)
    {
    	this.date=date;
    }
    public Set<Participant> getParticipants()
    {
    	return participants;
    }
}
