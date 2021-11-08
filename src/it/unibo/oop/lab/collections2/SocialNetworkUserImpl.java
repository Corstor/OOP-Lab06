package it.unibo.oop.lab.collections2;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * 
 * Instructions
 * 
 * This will be an implementation of
 * {@link it.unibo.oop.lab.collections2.SocialNetworkUser}:
 * 
 * 1) complete the definition of the methods by following the suggestions
 * included in the comments below.
 * 
 * @param <U>
 *            Specific user type
 */
public class SocialNetworkUserImpl<U extends User> extends UserImpl implements SocialNetworkUser<U> {

    /*
     * 
     * [FIELDS]
     * 
     * Define any necessary field
     * 
     * In order to save the people followed by a user organized in groups, adopt
     * a generic-type Map:
     * 
     * think of what type of keys and values would best suit the requirements
     */
	
	private final Map<String , List<U>> followedPeople;

    /*
     * [CONSTRUCTORS]
     * 
     * 1) Complete the definition of the constructor below, for building a user
     * participating in a social network, with 4 parameters, initializing:
     * 
     * - firstName - lastName - username - age and every other necessary field
     * 
     * 2) Define a further constructor where age is defaulted to -1
     */

    /**
     * Builds a new {@link SocialNetworkUserImpl}.
     * 
     * @param name
     *            the user firstname
     * @param surname
     *            the user lastname
     * @param userAge
     *            user's age
     * @param user
     *            alias of the user, i.e. the way a user is identified on an
     *            application
     */
    public SocialNetworkUserImpl(final String name, final String surname, final String user, final int userAge) {
		super(name, surname, user, userAge);
		this.followedPeople = new HashMap<>();
    }
    
    public SocialNetworkUserImpl(final String name, final String surname, final String user) {
		super(name, surname, user);
		this.followedPeople = new HashMap<>();
    }

    /*
     * [METHODS]
     * 
     * Implements the methods below
     */

    @Override
    public boolean addFollowedUser(final String circle, final U user) {
    	if (!this.followedPeople.containsKey(circle)) {
    		this.followedPeople.put(circle, new LinkedList<>(Arrays.asList(user)));
    	} else {
    		final var tempList = this.getFollowedUsersInGroupPrivate(circle);
    		for (final var i : tempList) {
    			if (i.equals(user)) {
    				return false;
    			}
    		}
    		this.getFollowedUsersInGroupPrivate(circle).add(user);
    	}
        return true;
    }

    private Collection<U> getFollowedUsersInGroupPrivate(final String groupName) {
    	return this.followedPeople.containsKey(groupName) ? this.followedPeople.get(groupName) : new LinkedList<U>();
    }
    
    @Override
    public Collection<U> getFollowedUsersInGroup(final String groupName) {
    	final Collection<U> tempCollection = new LinkedList<>();
    	for (final var i : this.getFollowedUsersInGroupPrivate(groupName)) {
    		tempCollection.add(i);
    	}
    	
        return tempCollection;
    }

    @Override
    public List<U> getFollowedUsers() {
    	List<U> tempList = new LinkedList<>();
    	for (final var i : this.followedPeople.values()) {
    		tempList.addAll(i);
    	}
        return tempList;
    }

}
