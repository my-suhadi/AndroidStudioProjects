package id.go.dephub.itjen.portal.model

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface PostDao {
    @Insert
    suspend fun insertSemua(vararg smuaPost: PostModel): List<Long>

    @Query("select * from postmodel")
    suspend fun getSemuaPost(): List<PostModel>

    @Query("select * from postmodel where postId = :postId")
    suspend fun getPost(postId: Int): PostModel

    @Query("delete from postmodel")
    suspend fun hapusSemuaPost()
}