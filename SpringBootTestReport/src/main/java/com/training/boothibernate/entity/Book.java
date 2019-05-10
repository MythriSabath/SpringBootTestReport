package com.training.boothibernate.entity;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "Book")
public class Book {
	@Id
	@Column(name = "bookId")
	private Integer bookId;
	@Column(name = "title")
	private String title;
	@Column(name = "price")
	private double price;
	@Column(name = "volume")
	private int volume;
	@Column(name = "publishDate")
	private Date publishDate;
	@Column(name = "subjectId")
	private Long subjectId;
	public Book() {
	}
	public Book(Integer bookId, String title, double price, int volume, String publishDateStr, Long subjectId) {
		super();
		this.bookId = bookId;
		this.title = title;
		this.price = price;
		this.volume = volume;
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		try {
			this.publishDate =   new Date((formatter.parse(publishDateStr).getTime()));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		this.setSubjectId(subjectId);
	}

	public Integer getBookId() {
		return bookId;
	}

	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getVolume() {
		return volume;
	}

	public void setVolume(int volume) {
		this.volume = volume;
	}

	public Date getPublishDate() {
		return publishDate;
	}

	public void setPublishDate(String publishDateStr) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		try {
			this.publishDate =   new Date((format.parse(publishDateStr).getTime()));
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	public Long getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(Long subjectId) {
		this.subjectId = subjectId;
	}

	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", title=" + title + ", price=" + price + ", volume=" + volume
				+ ", publishDate=" + publishDate + ", subjectId=" + subjectId + "]";
	}
}
