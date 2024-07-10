package com.example.demo;
import jakarta.persistence.*;

@Entity
public class Participant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;

    @ManyToOne
    @JoinColumn(name = "event_id", nullable = false)
    private Event event;
    public String getName()
    {
    	return this.name;
    }
    public String getEmail()
    {
    	return this.email;
    }
    public void setName(String name)
    {
    	this.name=name;
    }
    public void setEmail(String email)
    {
    	this.email=email;
    }
    public void setEvent(Event event)
    {
    	this.event=event;
    }
}
