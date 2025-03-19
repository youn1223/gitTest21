package album.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import album.model.AlbumDao;

@Controller
public class AlbumDeleteController {

	private final String command = "delete.ab";
	private final String gotoPage = "redirect:/list.ab";
	
	@Autowired
	AlbumDao albumDao;
	//albumList.jsp���� ����
	
	@RequestMapping(command)
	public String doAction(@RequestParam(value="num",required = true ) int num) {
		
		System.out.println("ADC num : " + num);
		
		
		int cnt = albumDao.deleteAlbum(num);
		return gotoPage;
	}
}
