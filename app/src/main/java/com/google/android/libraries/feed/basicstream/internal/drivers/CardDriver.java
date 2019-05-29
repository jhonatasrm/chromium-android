// Copyright 2018 The Feed Authors.
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//      http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package com.google.android.libraries.feed.basicstream.internal.drivers;

import static com.google.android.libraries.feed.common.Validators.checkState;

import android.support.annotation.VisibleForTesting;
import com.google.android.libraries.feed.api.actionmanager.ActionManager;
import com.google.android.libraries.feed.api.actionparser.ActionParserFactory;
import com.google.android.libraries.feed.api.modelprovider.ModelChild;
import com.google.android.libraries.feed.api.modelprovider.ModelChild.Type;
import com.google.android.libraries.feed.api.modelprovider.ModelCursor;
import com.google.android.libraries.feed.api.modelprovider.ModelFeature;
import com.google.android.libraries.feed.api.modelprovider.ModelProvider;
import com.google.android.libraries.feed.api.stream.ContentChangedListener;
import com.google.android.libraries.feed.common.logging.Logger;
import com.google.android.libraries.feed.host.action.ActionApi;
import com.google.android.libraries.feed.host.logging.BasicLoggingApi;
import com.google.android.libraries.feed.sharedstream.contextmenumanager.ContextMenuManager;
import com.google.android.libraries.feed.sharedstream.offlinemonitor.StreamOfflineMonitor;
import com.google.search.now.ui.action.FeedActionPayloadProto.FeedActionPayload;
import com.google.search.now.ui.stream.StreamSwipeExtensionProto.SwipeActionExtension;

/** {@link FeatureDriver} for cards. */
public class CardDriver implements FeatureDriver {
  private static final String TAG = "CardDriver";

  private final ActionApi actionApi;
  private final ActionManager actionManager;
  private final ActionParserFactory actionParserFactory;
  private final BasicLoggingApi basicLoggingApi;
  private final ModelFeature cardModel;
  private final ModelProvider modelProvider;
  private final int position;
  private final StreamOfflineMonitor streamOfflineMonitor;
  private final ContentChangedListener contentChangedListener;
  private final ContextMenuManager contextMenuManager;

  /*@Nullable*/ private ContentDriver contentDriver;

  CardDriver(
      ActionApi actionApi,
      ActionManager actionManager,
      ActionParserFactory actionParserFactory,
      BasicLoggingApi basicLoggingApi,
      ModelFeature cardModel,
      ModelProvider modelProvider,
      int position,
      StreamOfflineMonitor streamOfflineMonitor,
      ContentChangedListener contentChangedListener,
      ContextMenuManager contextMenuManager) {
    this.actionApi = actionApi;
    this.actionManager = actionManager;
    this.actionParserFactory = actionParserFactory;
    this.basicLoggingApi = basicLoggingApi;
    this.cardModel = cardModel;
    this.modelProvider = modelProvider;
    this.position = position;
    this.streamOfflineMonitor = streamOfflineMonitor;
    this.contentChangedListener = contentChangedListener;
    this.contextMenuManager = contextMenuManager;
  }

  @Override
  public void onDestroy() {
    if (contentDriver != null) {
      contentDriver.onDestroy();
    }
  }

  @Override
  /*@Nullable*/
  public LeafFeatureDriver getLeafFeatureDriver() {
    if (contentDriver == null) {
      contentDriver = createContentChild(cardModel);
    }

    if (contentDriver != null) {
      return contentDriver.getLeafFeatureDriver();
    }

    return null;
  }

  /*@Nullable*/
  private ContentDriver createContentChild(ModelFeature modelFeature) {
    ModelCursor cursor = modelFeature.getCursor();
    // TODO: add change listener to ModelFeature.
    ModelChild child;
    if ((child = cursor.getNextItem()) != null) {
      if (child.getType() != Type.FEATURE) {
        Logger.e(TAG, "ContentChild was not bound to a Feature, found type: %s", child.getType());
        return null;
      }
      ModelFeature contentModel = child.getModelFeature();
      checkState(contentModel.getStreamFeature().hasContent(), "Expected content for feature");
      return createContentDriver(
          contentModel,
          cardModel
              .getStreamFeature()
              .getCard()
              .getExtension(SwipeActionExtension.swipeActionExtension)
              .getSwipeAction());
    }

    return null;
  }

  @VisibleForTesting
  ContentDriver createContentDriver(ModelFeature contentModel, FeedActionPayload swipeAction) {
    return new ContentDriver(
        actionApi,
        actionManager,
        actionParserFactory,
        basicLoggingApi,
        contentModel,
        modelProvider,
        position,
        swipeAction,
        streamOfflineMonitor,
        contentChangedListener,
        contextMenuManager);
  }
}
