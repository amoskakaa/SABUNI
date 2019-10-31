package com.example.soap;

import localhost.university.Type;
import localhost.university.University;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Component
public class UniversityRepository {
    private static final Map<String, University> universities = new HashMap<>();

    @PostConstruct
    public void loadData() {

        University ku = new University();
        ku.setName("kenyatta");
        ku.setLocation("Thika");
        ku.setFounded(1900);
        ku.setType(Type.PUBLIC);
        universities.put(ku.getName(), ku);
        universities.put(ku.getLocation(), ku);

        University mku = new University();
        mku.setName("Mount kenya");
        mku.setLocation("Thika");
        mku.setFounded(2000);
        mku.setType(Type.PRIVATE);
        universities.put(mku.getName(), mku);
        universities.put(mku.getLocation(), mku);

        University strath = new University();
        strath.setName("Strathmore");
        strath.setLocation("Ole Sangale");
        strath.setFounded(1960);
        strath.setType(Type.PRIVATE);
        universities.put(strath.getName(), strath);
        universities.put(strath.getLocation(), strath);
    }
        public University findUniversity(String name) {
            Assert.notNull(name, "The university's name must not be null");
            return universities.get(name);
        }
    public University findUniversityLocation(String location) {
        Assert.notNull(location, "The university's location must not be null");
        return universities.get(location);
    }
}


