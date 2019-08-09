package ru.rage.rssreader.presentation.ui.rss.feeds

import com.arellomobile.mvp.InjectViewState
import ru.rage.rssreader.domain.usecase.GetRssUseCase
import ru.rage.rssreader.presentation.model.RssFeedModel
import ru.rage.rssreader.presentation.model.mapper.RssModelMapper
import ru.rage.rssreader.presentation.base.BaseNavControllerRouter
import ru.rage.rssreader.presentation.base.BasePresenter
import ru.rage.rssreader.presentation.base.common.exception.ExceptionMapper
import ru.rage.rssreader.presentation.base.rx.PresentationSingleTransformer
import javax.inject.Inject
import javax.inject.Named

@InjectViewState
class RssFeedListPresenter @Inject constructor(
    private val getRssUseCase: GetRssUseCase,
    @Named("url_argument")
    private val url: String,
    private val router: BaseNavControllerRouter,
    private val exceptionMapper: ExceptionMapper
) : BasePresenter<IRssFeedListView>(), IRssFeedListPresenter {

    private fun update() = getRssUseCase
        .getRss(url)
        .map(RssModelMapper::map)
        .compose(PresentationSingleTransformer())
        .doOnSubscribe { viewState?.setProgressVisible(true) }
        .doAfterTerminate { viewState?.setProgressVisible(false) }
        .subscribe({
            viewState?.showRssFeedList(it.feeds)
        }, {
            viewState?.showMessage(exceptionMapper.process(it))
        })
        .disposeWhenDestroy()

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        update()
    }

    override fun onUpdate() {
        update()
    }

    override fun onSelectFeed(rssFeedModel: RssFeedModel) {
        router.perform {
            navigate(RssFeedListFragmentDirections.rssFeedListFragmentToRssFeedFragment(rssFeedModel))
        }
    }

}