package org.springframework.samples.petclinic.feeding;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

public class FeedingService {

    private FeedingRepository feedingRepository;	
	
	@Autowired
	private FeedingService feedingService;

    public List<Feeding> getAll(){
        return null;
    }

    public List<FeedingType> getAllFeedingTypes(){
        return null;
    }

    public FeedingType getFeedingType(String typeName) {
        return null;
    }

    public Feeding save(Feeding p) throws UnfeasibleFeedingException {
        return null;       
    }

    
}
