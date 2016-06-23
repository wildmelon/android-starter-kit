package starter.kit.rx;

import android.support.annotation.ColorInt;
import android.support.v7.widget.RecyclerView;
import com.paginate.recycler.LoadingListItemCreator;
import java.util.ArrayList;
import java.util.HashMap;
import rx.Observable;
import starter.kit.model.Entity;
import starter.kit.util.Maps;
import support.ui.adapters.BaseEasyViewHolderFactory;
import support.ui.adapters.EasyViewHolder;

public class StarterFragConfig<E extends Entity> {

  private Observable<ArrayList<E>> resourceObservable;

  // adapter config
  private BaseEasyViewHolderFactory viewHolderFactory;
  private HashMap<Class, Class<? extends EasyViewHolder>> boundViewHolders;

  // RecyclerView config
  private RecyclerView.LayoutManager layoutManager;
  private RecyclerView.ItemDecoration decor;
  private RecyclerView.ItemAnimator animator;

  // SwipeRefreshLayout config
  private int[] colorSchemeColors;
  private boolean enabled;

  // load more config
  private boolean addLoadingListItem;
  private int spanSizeLookup;
  private LoadingListItemCreator loadingListItemCreator;
  private int loadingTriggerThreshold;

  public Observable<ArrayList<E>> getResourceObservable() {
    return resourceObservable;
  }

  public BaseEasyViewHolderFactory getViewHolderFactory() {
    return viewHolderFactory;
  }

  public HashMap<Class, Class<? extends EasyViewHolder>> getBoundViewHolders() {
    return boundViewHolders;
  }

  public RecyclerView.LayoutManager getLayoutManager() {
    return layoutManager;
  }

  public RecyclerView.ItemDecoration getDecor() {
    return decor;
  }

  public RecyclerView.ItemAnimator getAnimator() {
    return animator;
  }

  public int[] getColorSchemeColors() {
    return colorSchemeColors;
  }

  public boolean isEnabled() {
    return enabled;
  }

  public boolean canAddLoadingListItem() {
    return addLoadingListItem;
  }

  public int getSpanSizeLookup() {
    return spanSizeLookup;
  }

  public LoadingListItemCreator getLoadingListItemCreator() {
    return loadingListItemCreator;
  }

  public int getLoadingTriggerThreshold() {
    return loadingTriggerThreshold;
  }

  public static class Builder<E extends Entity> {
    private Observable<ArrayList<E>> resourceObservable;
    private BaseEasyViewHolderFactory viewHolderFactory;
    private HashMap<Class, Class<? extends EasyViewHolder>> boundViewHolders = Maps.newHashMap();

    private RecyclerView.LayoutManager layoutManager;
    private RecyclerView.ItemDecoration decor;
    private RecyclerView.ItemAnimator animator;

    private int[] colorSchemeColors;
    private boolean enabled = true; // default true

    private boolean addLoadingListItem = true; // default can load more
    private int spanSizeLookup;
    private LoadingListItemCreator loadingListItemCreator;
    private int loadingTriggerThreshold = 2; // default 2

    public StarterFragConfig build() {
      StarterFragConfig config = new StarterFragConfig();
      config.resourceObservable = resourceObservable;
      config.viewHolderFactory = viewHolderFactory;
      config.boundViewHolders = boundViewHolders;
      config.layoutManager = layoutManager;
      config.decor = decor;
      config.animator = animator;
      config.colorSchemeColors = colorSchemeColors;
      config.enabled = enabled;
      config.addLoadingListItem = addLoadingListItem;
      config.spanSizeLookup = spanSizeLookup;
      config.loadingListItemCreator = loadingListItemCreator;
      config.loadingTriggerThreshold = loadingTriggerThreshold;
      return config;
    }

    public Builder observable(Observable<ArrayList<E>> observable) {
      resourceObservable = observable;
      return this;
    }

    public Builder viewHolderFactory(BaseEasyViewHolderFactory viewHolderFactory) {
      this.viewHolderFactory = viewHolderFactory;
      return this;
    }

    public Builder bind(Class valueClass, Class<? extends EasyViewHolder> viewHolder) {
      boundViewHolders.put(valueClass, viewHolder);
      return this;
    }

    public Builder recyclerLayoutManager(RecyclerView.LayoutManager layoutManager) {
      this.layoutManager = layoutManager;
      return this;
    }

    public Builder recyclerViewDecor(RecyclerView.ItemDecoration decor) {
      this.decor = decor;
      return this;
    }

    public Builder recyclerViewAnimator(RecyclerView.ItemAnimator animator) {
      this.animator = animator;
      return this;
    }

    public Builder swipeRefreshLayoutColors(@ColorInt int... colors) {
      this.colorSchemeColors = colors;
      return this;
    }

    public Builder swipeRefreshLayoutEnabled(boolean enabled) {
      this.enabled = enabled;
      return this;
    }

    public Builder addLoadingListItem(boolean addLoadingListItem) {
      this.addLoadingListItem = addLoadingListItem;
      return this;
    }

    public Builder spanSizeLookup(int spanSizeLookup) {
      this.spanSizeLookup = spanSizeLookup;
      return this;
    }

    public Builder loadingListItemCreator(LoadingListItemCreator loadingListItemCreator) {
      this.loadingListItemCreator = loadingListItemCreator;
      return this;
    }

    public Builder loadingTriggerThreshold(int loadingTriggerThreshold) {
      this.loadingTriggerThreshold = loadingTriggerThreshold;
      return this;
    }
  }
}
