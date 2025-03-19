package album.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import album.model.AlbumBean;
import album.model.AlbumDao;
import utility.Paging;
 
@Controller
public class AlbumListController {
	
	private final String command = "/list.ab";
	private final String getPage = "albumList";
	
	@Autowired
	private AlbumDao albumDao ;
	
	// start.jsp(X) , albumList.jsp(2)
	@RequestMapping(value=command)
	public ModelAndView doAction(
								@RequestParam(value="whatColumn",required = false) String whatColumn,
								@RequestParam(value="keyword",required = false) String keyword,
								@RequestParam(value="pageNumber",required = false) String pageNumber,
								HttpServletRequest request) {
//		기본값:
		
		System.out.println("whatColumn : " + whatColumn); // title, singer
		System.out.println("keyword : " + keyword); // 레드, BT
		
		Map<String,String> map = new HashMap<String,String>();
		map.put("whatColumn", whatColumn); // whatColumn = title or singer
		map.put("keyword", "%"+keyword+"%"); // keyword = 검색어 
		
		int totalCount = albumDao.getTotalCount(map);
		
		String url = request.getContextPath()+command; // /ex/list.ab
		
		Paging pageInfo = new Paging(pageNumber,null,totalCount,url,whatColumn,keyword); 
		
		List<AlbumBean> lists = albumDao.getAlbumList(map,pageInfo); 
		ModelAndView mav = new ModelAndView();
		mav.addObject("albumLists", lists);
		mav.addObject("pageInfo", pageInfo);
		mav.setViewName(getPage);
		return mav;
		// /WEB-INF/album/albumList.jsp
	}
}





