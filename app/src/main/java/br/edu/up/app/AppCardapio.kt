package br.edu.up.app

import android.app.Application
import android.content.Context
import br.edu.up.app.data.*
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.HiltAndroidApp
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@HiltAndroidApp
@InstallIn(SingletonComponent::class)
class AppCardapio : Application() {

    @Provides
    fun provideProdutoReposity(produtoDao: ProdutoDao)
            : ProdutoRepositorySQLite{
        return ProdutoRepositorySQLite(produtoDao)
    }

    @Provides
    fun provideProdutoRepositoryFirebase(produtosRef: CollectionReference)
            : ProdutoRepository {
        return  ProdutoRepositoryFirebase(produtosRef)
    }

    @Provides
    fun provideProdutoDao(banco: BancoSQLite) : ProdutoDao{
        return banco.produtoDao()
    }
    @Provides
    fun provideProdutosRef(): CollectionReference{
        return Firebase.firestore.collection("produtos")
    }



    @Provides
    @Singleton
    fun provideBanco(@ApplicationContext ctx: Context) : BancoSQLite{
        return BancoSQLite.get(ctx)
    }

//    lateinit var viewModel: ProdutoViewModel
//
//    override fun onCreate() {
//        super.onCreate()
//        val banco = BancoSQLite.get(applicationContext)
//        val repository = ProdutoRepository(banco.produtoDao())
//        viewModel = ProdutoViewModel(repository)
//    }
}