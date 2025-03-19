package album.model;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

public class AlbumBean {
	private int num;
	
	@NotBlank(message = "제목 누락")
	private String title; // 누락
	
	@NotEmpty(message="가수명 누락")
	@Length(min = 3, max = 7, message = "가수명 3~7자리 입력하세요")
	private String singer; // 3~7
	
	@Min(value = 1000,message = "최소 1000원 이상입니다")
	@Max(value = 10000,message = "최대 1000원입니다")
	private String price; // 최소 1000원 이상
	
	private String day;
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getTitle() {
		System.out.println("getTitle()");
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getSinger() {
		return singer;
	}
	public void setSinger(String singer) {
		this.singer = singer;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getDay() {
		return day;
	}
	public void setDay(String day) {
		this.day = day;
	}
	
}
