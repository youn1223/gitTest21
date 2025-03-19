package album.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import utility.Paging;

//AlbumDao myAlbumDao =  new AlbumDao();
@Component("myAlbumDao")
public class AlbumDao {

	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
	//객r-c.xml
	
	public AlbumDao() {
		System.out.println("AlbumDao()");
	}
	
	public List<AlbumBean> getAlbumList(Map<String,String> map,Paging pageInfo) {
//		List<AlbumBean> lists = new ArrayList<AlbumBean>();
//		// select * from albums
//		prepareStatment();
//		rs = exeucteQuery();
//		while() {
//			setNum()
//			lists.add(null)
//		}
//		return lists;
		RowBounds rowBounds = new RowBounds(pageInfo.getOffset(), pageInfo.getLimit());
		
		List<AlbumBean> lists = sqlSessionTemplate.selectList("album.AlbumBean.getAlbumList",map,rowBounds); // namespace.id   
		System.out.println("lists.size() :" + lists.size());
		return lists;
	}//getAlbumList
	
	public int insertAlbum(AlbumBean album) {
		
//		String sql = "insert~ ? "
//		sql분석
//		1? setString(1,album.getTitle())
//		2?setInt
//			실행executeUpdate()
			
		int cnt = sqlSessionTemplate.insert("album.AlbumBean.insertAlbum",album);
		System.out.println("insertAlbum cnt : " + cnt);
		return cnt;
	}//insertAlbum
	
	public int deleteAlbum(int num) {
		
//		String sql = "delete from albums where num=?";
//		sql문 분석
//		(1,num)
//		실행
//		예외처리
		
		int cnt = sqlSessionTemplate.delete("album.AlbumBean.deleteAlbum",num);
		System.out.println("deleteAlbum cnt : " + cnt);
		return cnt;
	}// deleteAlbum
	
	public AlbumBean getOneSelect(int num) {
		AlbumBean album = sqlSessionTemplate.selectOne("album.AlbumBean.getOneSelect", num);
		return album;
	}//getOneSelect

	public int updateAlbum(AlbumBean album) {
		int cnt = sqlSessionTemplate.update("album.AlbumBean.updateAlbum",album);
		return cnt;
	}//updateAlbum

	public int getTotalCount(Map<String, String> map) {
		int totalCount = sqlSessionTemplate.selectOne("album.AlbumBean.getTotalCount",map);
		return totalCount;
	}//getTotalCount
}
