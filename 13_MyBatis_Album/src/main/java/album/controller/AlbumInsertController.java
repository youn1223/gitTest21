package album.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import album.model.AlbumBean;
import album.model.AlbumDao;

@Controller
public class AlbumInsertController {

	private final String getPage = "albumInsertForm";
	private final String gotoPage = "redirect:/list.ab";
	private final String command = "insert.ab";
	
	@Autowired
	AlbumDao albumDao;
	
	// list.jsp에서 추가하기 버튼
	@RequestMapping(value=command, method = RequestMethod.GET)
	public String doActionGet() {
		return getPage;
		// /WEB-INF/album/albumInsertForm.jsp
	}
	
	// albumInsertForm.jsp
	@RequestMapping(value=command, method = RequestMethod.POST)
	public ModelAndView doActionPost(@ModelAttribute("album") @Valid AlbumBean album, BindingResult result) {
		
		ModelAndView mav = new ModelAndView();
		
		if(result.hasErrors()) {
			mav.setViewName(getPage);
			return mav;
		}
		
		//AlbumDao albumDao = new AlbumDao();
		int cnt = albumDao.insertAlbum(album);
		
		mav.setViewName(gotoPage);
		return mav;
		// /WEB-INF/album/albumInsertForm.jsp
	}
}




