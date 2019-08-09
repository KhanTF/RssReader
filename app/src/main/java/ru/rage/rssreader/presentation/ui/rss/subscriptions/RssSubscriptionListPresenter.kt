package ru.rage.rssreader.presentation.ui.rss.subscriptions

import com.arellomobile.mvp.InjectViewState
import ru.rage.rssreader.domain.usecase.DeleteRssUrlUseCase
import ru.rage.rssreader.domain.usecase.GetRssUrlUseCase
import ru.rage.rssreader.domain.usecase.SaveRssUrlUseCase
import ru.rage.rssreader.presentation.model.RssUrlModel
import ru.rage.rssreader.presentation.model.mapper.RssUrlModelMapper
import ru.rage.rssreader.presentation.base.BaseNavControllerRouter
import ru.rage.rssreader.presentation.base.BasePresenter
import ru.rage.rssreader.presentation.base.common.exception.ExceptionMapper
import ru.rage.rssreader.presentation.base.rx.PresentationSingleTransformer
import javax.inject.Inject

@InjectViewState
class RssSubscriptionListPresenter @Inject constructor(
    private val getRssUrlUseCase: GetRssUrlUseCase,
    private val deleteRssUrlUseCase: DeleteRssUrlUseCase,
    private val saveRssUrlUseCase: SaveRssUrlUseCase,
    private val router: BaseNavControllerRouter,
    private val exceptionMapper: ExceptionMapper
) : BasePresenter<IRssSubscriptionListView>(), IRssSubscriptionListPresenter {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        getRssUrlUseCase
            .getRssUrl()
            .map(RssUrlModelMapper::map)
            .toList()
            .compose(PresentationSingleTransformer())
            .doOnSubscribe { viewState?.setProgressVisible(true) }
            .doAfterTerminate { viewState?.setProgressVisible(false) }
            .subscribe({
                viewState?.setEmptyVisible(it.isEmpty())
                viewState?.showRssList(it)
            },{
                viewState?.showMessage(exceptionMapper.process(it))
            })
            .disposeWhenDestroy()
    }

    override fun onAddRssUrl(name: String, url: String) {
        saveRssUrlUseCase
            .addRss(name, url)
            .andThen(getRssUrlUseCase.getRssUrl())
            .map(RssUrlModelMapper::map)
            .toList()
            .compose(PresentationSingleTransformer())
            .subscribe({
                viewState?.setEmptyVisible(it.isEmpty())
                viewState?.showRssList(it)
            },{
                viewState?.showMessage(exceptionMapper.process(it))
            })
            .disposeWhenDestroy()
    }

    override fun onDeleteRssUrl(rssUrlModel: RssUrlModel) {
        deleteRssUrlUseCase
            .deleteRss(rssUrlModel.url)
            .andThen(getRssUrlUseCase.getRssUrl())
            .map(RssUrlModelMapper::map)
            .toList()
            .compose(PresentationSingleTransformer())
            .subscribe({
                viewState?.setEmptyVisible(it.isEmpty())
                viewState?.showRssList(it)
            },{
                viewState?.showMessage(exceptionMapper.process(it))
            })
            .disposeWhenDestroy()
    }

    override fun onSelectRssUrl(rssUrlModel: RssUrlModel) {
        router.perform {
            navigate(RssSubscriptionListFragmentDirections.rssSubscriptionListFragmentToRssFeedListFragment(rssUrlModel.url,rssUrlModel.name))
        }
    }

}