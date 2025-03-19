package album.model;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

public class AlbumBean {
	private int num;
	
	@NotBlank(message = "���� ����")
	private String title; // ����
	
	@NotEmpty(message="������ ����")
	@Length(min = 3, max = 7, message = "������ 3~7�ڸ� �Է��ϼ���")
	private String singer; // 3~7
	
	@Min(value = 1000,message = "�ּ� 1000�� �̻��Դϴ�")
	@Max(value = 10000,message = "�ִ� 1000���Դϴ�")
	private String price; // �ּ� 1000�� �̻�
	
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
