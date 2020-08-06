package com.yc.favorite;
import org.apache.ibatis.session.SqlSession;

import com.yc.favorite.bean.Favorite;
import com.yc.favorite.bean.Tag;
import com.yc.favorite.bean.TagFavorite;
import com.yc.favorite.dao.FavoritMapper;
import com.yc.favorite.dao.TagFavoriteMapper;
import com.yc.favorite.dao.TagMapper;
import com.yc.favorite.util.MyBatisHelper;

public class FavoriteBiz {

	
	public void addFavorite(Favorite f) {
		
		
        SqlSession session=MyBatisHelper.openSession();
		
		FavoritMapper fm=session.getMapper(FavoritMapper.class);
		TagMapper tm=session.getMapper(TagMapper.class);
		TagFavoriteMapper tfm=session.getMapper(TagFavoriteMapper.class);
		
		try {
		fm.insert(f);
		
		String[] tags=f.getFtags().split("[,，；;]");
		for(String tag:tags) {
			Tag tagobj=new Tag();
			if(tm.updateCount(tag)==0) {
				
				tagobj.setTname(tag);
				tm.insert(tagobj);
			}else {
				tagobj=tm.selcetByNmae(tag);
				
			}
			TagFavorite tf=new TagFavorite();
			tf.setTid(tagobj.getTid());
			tf.setFid(f.getFid());
			tfm.insert(tf);
			
			session.commit();
		}
		
	}catch(Exception e) {
		e.printStackTrace();
		session.rollback();
	}finally {
		session.close();
	}
	}
}
