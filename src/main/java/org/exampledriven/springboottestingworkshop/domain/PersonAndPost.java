package org.exampledriven.springboottestingworkshop.domain;

import java.util.List;
import java.util.Objects;

/**
 * Created by Peter Szanto on 7/3/2017.
 */
public class PersonAndPost {

    private Person person;
    private List<Post> posts;

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PersonAndPost that = (PersonAndPost) o;
        return Objects.equals(person, that.person) &&
                Objects.equals(posts, that.posts);
    }

    @Override
    public int hashCode() {
        return Objects.hash(person, posts);
    }

    @Override
    public String toString() {
        return "PersonAndPost{" +
                "person=" + person +
                ", posts=" + posts +
                '}';
    }
}
