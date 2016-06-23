package ua.blog.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "groupArticles")
public class GroupArticles implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "groupName")
	private String groupName;

	@OneToMany(cascade = { CascadeType.MERGE }, fetch = FetchType.EAGER, mappedBy = "groupArticles")
	private List<Article> grouplist;

	public GroupArticles() {

	}

	public GroupArticles(String groupName) {
		super();
		this.groupName = groupName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public List<Article> getGrouplist() {
		return grouplist;
	}

	public void setGrouplist(List<Article> grouplist) {
		this.grouplist = grouplist;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		GroupArticles other = (GroupArticles) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "GroupArticles [id=" + id + ", groupName=" + groupName + "]";
	}

}
