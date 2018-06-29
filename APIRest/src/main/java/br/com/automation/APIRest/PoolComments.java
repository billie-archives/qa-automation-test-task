package br.com.automation.APIRest;

import java.util.ArrayList;
import java.util.List;

/**
 * This class implements the List of comments which come from API. It was
 * created in order to separate the logic from the testing steps.
 * 
 * @author mariaisabel
 *
 */
public class PoolComments {
	List<Comment> commentsList;

	/**
	 * Class constructor which initialized the array list of comments
	 */
	public PoolComments() {
		commentsList = new ArrayList<Comment>();
	}

	/**
	 * Returns the list of comments
	 * 
	 * @return a List of comments
	 */
	public List<Comment> getCommentsList() {
		return commentsList;
	}

	/**
	 * Set the comments list
	 * 
	 * @param commentsList
	 *            a List of Comments objects
	 */
	public void setCommentsList(List<Comment> commentsList) {
		this.commentsList = commentsList;
	}

	/**
	 * Verify if a comment with specific post Id, name, email and body exist on the
	 * List of comments
	 * 
	 * @param postId
	 *            the post Id String
	 * @param name
	 *            the comment name String
	 * @param email
	 *            the comment email String
	 * @param body
	 *            the comment body String
	 * @return true if the comment exists in the List of comments 
	 * 		   false if no comment with these values was found
	 */
	public boolean verifyIfCommentExistsOnList(String postId, String name, String email, String body) {
		for (int i = 0; i < commentsList.size(); i++) {
			String postId_i = commentsList.get(i).getPostId();
			String name_i = commentsList.get(i).getName();
			String email_i = commentsList.get(i).getEmail();
			String body_i = commentsList.get(i).getBody();

			if (postId_i.equals(postId) && name_i.equals(name) && email_i.equals(email) && body_i.equals(body)) {
				return true;
			}
		}
		return false;
	}
}
