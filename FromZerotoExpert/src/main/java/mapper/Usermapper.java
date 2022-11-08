package mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import pojo.User;

public interface Usermapper {
   @Select("select * from usr where username=#{username} and password=#{password}")
   User SelectAll(@Param("username")String username,@Param("password")String password);

   @Select("select *from usr where username=#{username}")
   User selectAllByUsernameUser(String username);

   @Insert("insert into usr values(null,#{username},#{password},null)")
   void addAll(User user);
}
