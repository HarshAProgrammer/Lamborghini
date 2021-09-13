package com.rackluxury.lamborghini.reddit;

import javax.inject.Singleton;

import dagger.Component;
import com.rackluxury.lamborghini.reddit.activities.RedditAccountPostsActivity;
import com.rackluxury.lamborghini.reddit.activities.AccountSavedThingActivity;
import com.rackluxury.lamborghini.reddit.activities.AnonymousSubscriptionsActivity;
import com.rackluxury.lamborghini.reddit.activities.RedditCommentActivity;
import com.rackluxury.lamborghini.reddit.activities.CreateMultiRedditActivity;
import com.rackluxury.lamborghini.reddit.activities.CustomThemeListingActivity;
import com.rackluxury.lamborghini.reddit.activities.RedditCustomThemePreviewActivity;
import com.rackluxury.lamborghini.reddit.activities.CustomizePostFilterActivity;
import com.rackluxury.lamborghini.reddit.activities.RedditCustomizeThemeActivity;
import com.rackluxury.lamborghini.reddit.activities.RedditEditCommentActivity;
import com.rackluxury.lamborghini.reddit.activities.RedditEditMultiRedditActivity;
import com.rackluxury.lamborghini.reddit.activities.RedditEditPostActivity;
import com.rackluxury.lamborghini.reddit.activities.FetchRandomSubredditOrPostActivity;
import com.rackluxury.lamborghini.reddit.activities.RedditFilteredPostsActivity;
import com.rackluxury.lamborghini.reddit.activities.FullMarkdownActivity;
import com.rackluxury.lamborghini.reddit.activities.GiveAwardActivity;
import com.rackluxury.lamborghini.reddit.activities.RedditInboxActivity;
import com.rackluxury.lamborghini.reddit.activities.RedditLinkResolverActivity;
import com.rackluxury.lamborghini.reddit.activities.RedditLockScreenActivity;
import com.rackluxury.lamborghini.reddit.activities.RedditLoginActivity;
import com.rackluxury.lamborghini.reddit.activities.RedditMainActivity;
import com.rackluxury.lamborghini.reddit.activities.MultiredditSelectionActivity;
import com.rackluxury.lamborghini.reddit.activities.RedditPostFilterPreferenceActivity;
import com.rackluxury.lamborghini.reddit.activities.PostFilterUsageListingActivity;
import com.rackluxury.lamborghini.reddit.activities.RedditPostGalleryActivity;
import com.rackluxury.lamborghini.reddit.activities.RedditPostImageActivity;
import com.rackluxury.lamborghini.reddit.activities.RedditPostLinkActivity;
import com.rackluxury.lamborghini.reddit.activities.RedditPostTextActivity;
import com.rackluxury.lamborghini.reddit.activities.RedditPostVideoActivity;
import com.rackluxury.lamborghini.reddit.activities.RedditRPANActivity;
import com.rackluxury.lamborghini.reddit.activities.RedditRulesActivity;
import com.rackluxury.lamborghini.reddit.activities.RedditSearchActivity;
import com.rackluxury.lamborghini.reddit.activities.RedditSearchUsersResultActivity;
import com.rackluxury.lamborghini.reddit.activities.RedditSettingsActivity;
import com.rackluxury.lamborghini.reddit.activities.RedditSubredditMultiselectionActivity;
import com.rackluxury.lamborghini.reddit.activities.RedditTrendingActivity;
import com.rackluxury.lamborghini.reddit.activities.RedditViewPostDetailActivity;
import com.rackluxury.lamborghini.reddit.activities.RedditViewPrivateMessagesActivity;
import com.rackluxury.lamborghini.reddit.activities.RedditViewRedditGalleryActivity;
import com.rackluxury.lamborghini.reddit.activities.RedditViewVideoActivity;
import com.rackluxury.lamborghini.reddit.activities.ReportActivity;
import com.rackluxury.lamborghini.reddit.activities.SearchResultActivity;
import com.rackluxury.lamborghini.reddit.activities.RedditSearchSubredditsResultActivity;
import com.rackluxury.lamborghini.reddit.activities.SelectUserFlairActivity;
import com.rackluxury.lamborghini.reddit.activities.SelectedSubredditsAndUsersActivity;
import com.rackluxury.lamborghini.reddit.activities.SendPrivateMessageActivity;
import com.rackluxury.lamborghini.reddit.activities.RedditSubmitCrosspostActivity;
import com.rackluxury.lamborghini.reddit.activities.RedditSubredditSelectionActivity;
import com.rackluxury.lamborghini.reddit.activities.RedditSubscribedThingListingActivity;
import com.rackluxury.lamborghini.reddit.activities.SuicidePreventionActivity;
import com.rackluxury.lamborghini.reddit.activities.ViewImageOrGifActivity;
import com.rackluxury.lamborghini.reddit.activities.RedditViewImgurMediaActivity;
import com.rackluxury.lamborghini.reddit.activities.RedditViewMultiRedditDetailActivity;
import com.rackluxury.lamborghini.reddit.activities.RedditViewSubredditDetailActivity;
import com.rackluxury.lamborghini.reddit.activities.RedditViewUserDetailActivity;
import com.rackluxury.lamborghini.reddit.activities.RedditWebViewActivity;
import com.rackluxury.lamborghini.reddit.bottomsheetfragments.FlairBottomSheetFragment;
import com.rackluxury.lamborghini.reddit.fragments.CommentsListingFragment;
import com.rackluxury.lamborghini.reddit.fragments.FollowedUsersListingFragment;
import com.rackluxury.lamborghini.reddit.fragments.InboxFragment;
import com.rackluxury.lamborghini.reddit.fragments.MultiRedditListingFragment;
import com.rackluxury.lamborghini.reddit.fragments.PostFragment;
import com.rackluxury.lamborghini.reddit.fragments.SidebarFragment;
import com.rackluxury.lamborghini.reddit.fragments.SubredditListingFragment;
import com.rackluxury.lamborghini.reddit.fragments.SubscribedSubredditsListingFragment;
import com.rackluxury.lamborghini.reddit.fragments.UserListingFragment;
import com.rackluxury.lamborghini.reddit.fragments.ViewImgurImageFragment;
import com.rackluxury.lamborghini.reddit.fragments.ViewImgurVideoFragment;
import com.rackluxury.lamborghini.reddit.fragments.ViewPostDetailFragment;
import com.rackluxury.lamborghini.reddit.fragments.ViewRPANBroadcastFragment;
import com.rackluxury.lamborghini.reddit.fragments.ViewRedditGalleryImageOrGifFragment;
import com.rackluxury.lamborghini.reddit.fragments.ViewRedditGalleryVideoFragment;
import com.rackluxury.lamborghini.reddit.services.RedditDownloadMediaService;
import com.rackluxury.lamborghini.reddit.services.RedditDownloadRedditVideoService;
import com.rackluxury.lamborghini.reddit.services.MaterialYouService;
import com.rackluxury.lamborghini.reddit.services.SubmitPostService;
import com.rackluxury.lamborghini.reddit.settings.AdvancedPreferenceFragment;
import com.rackluxury.lamborghini.reddit.settings.CrashReportsFragment;
import com.rackluxury.lamborghini.reddit.settings.CustomizeBottomAppBarFragment;
import com.rackluxury.lamborghini.reddit.settings.CustomizeMainPageTabsFragment;
import com.rackluxury.lamborghini.reddit.settings.DownloadLocationPreferenceFragment;
import com.rackluxury.lamborghini.reddit.settings.GesturesAndButtonsPreferenceFragment;
import com.rackluxury.lamborghini.reddit.settings.MainPreferenceFragment;
import com.rackluxury.lamborghini.reddit.settings.MiscellaneousPreferenceFragment;
import com.rackluxury.lamborghini.reddit.settings.NotificationPreferenceFragment;
import com.rackluxury.lamborghini.reddit.settings.NsfwAndSpoilerFragment;
import com.rackluxury.lamborghini.reddit.settings.PostHistoryFragment;
import com.rackluxury.lamborghini.reddit.settings.SecurityPreferenceFragment;
import com.rackluxury.lamborghini.reddit.settings.ThemePreferenceFragment;
import com.rackluxury.lamborghini.reddit.settings.TranslationFragment;
import com.rackluxury.lamborghini.reddit.settings.VideoPreferenceFragment;

@Singleton
@Component(modules = com.rackluxury.lamborghini.reddit.AppModule.class)
public interface AppComponent {
    void inject(RedditMainActivity redditMainActivity);

    void inject(RedditLoginActivity redditLoginActivity);

    void inject(PostFragment postFragment);

    void inject(SubredditListingFragment subredditListingFragment);

    void inject(UserListingFragment userListingFragment);

    void inject(RedditViewPostDetailActivity redditViewPostDetailActivity);

    void inject(RedditViewSubredditDetailActivity redditViewSubredditDetailActivity);

    void inject(RedditViewUserDetailActivity redditViewUserDetailActivity);

    void inject(RedditCommentActivity redditCommentActivity);

    void inject(RedditSubscribedThingListingActivity redditSubscribedThingListingActivity);

    void inject(RedditPostTextActivity redditPostTextActivity);

    void inject(SubscribedSubredditsListingFragment subscribedSubredditsListingFragment);

    void inject(RedditPostLinkActivity redditPostLinkActivity);

    void inject(RedditPostImageActivity redditPostImageActivity);

    void inject(RedditPostVideoActivity redditPostVideoActivity);

    void inject(FlairBottomSheetFragment flairBottomSheetFragment);

    void inject(RedditRulesActivity redditRulesActivity);

    void inject(CommentsListingFragment commentsListingFragment);

    void inject(SubmitPostService submitPostService);

    void inject(RedditFilteredPostsActivity redditFilteredPostsActivity);

    void inject(SearchResultActivity searchResultActivity);

    void inject(RedditSearchSubredditsResultActivity redditSearchSubredditsResultActivity);

    void inject(FollowedUsersListingFragment followedUsersListingFragment);

    void inject(RedditSubredditSelectionActivity redditSubredditSelectionActivity);

    void inject(RedditEditPostActivity redditEditPostActivity);

    void inject(RedditEditCommentActivity redditEditCommentActivity);

    void inject(RedditAccountPostsActivity redditAccountPostsActivity);

    void inject(com.rackluxury.lamborghini.reddit.PullNotificationWorker pullNotificationWorker);

    void inject(RedditInboxActivity redditInboxActivity);

    void inject(NotificationPreferenceFragment notificationPreferenceFragment);

    void inject(RedditLinkResolverActivity redditLinkResolverActivity);

    void inject(RedditSearchActivity redditSearchActivity);

    void inject(RedditSettingsActivity redditSettingsActivity);

    void inject(MainPreferenceFragment mainPreferenceFragment);

    void inject(AccountSavedThingActivity accountSavedThingActivity);

    void inject(ViewImageOrGifActivity viewGIFActivity);

    void inject(RedditViewMultiRedditDetailActivity redditViewMultiRedditDetailActivity);

    void inject(RedditViewVideoActivity redditViewVideoActivity);

    void inject(GesturesAndButtonsPreferenceFragment gesturesAndButtonsPreferenceFragment);

    void inject(CreateMultiRedditActivity createMultiRedditActivity);

    void inject(RedditSubredditMultiselectionActivity redditSubredditMultiselectionActivity);

    void inject(ThemePreferenceFragment themePreferenceFragment);

    void inject(RedditCustomizeThemeActivity redditCustomizeThemeActivity);

    void inject(CustomThemeListingActivity customThemeListingActivity);

    void inject(SidebarFragment sidebarFragment);

    void inject(AdvancedPreferenceFragment advancedPreferenceFragment);

    void inject(RedditCustomThemePreviewActivity redditCustomThemePreviewActivity);

    void inject(RedditEditMultiRedditActivity redditEditMultiRedditActivity);

    void inject(SelectedSubredditsAndUsersActivity selectedSubredditsAndUsersActivity);

    void inject(ReportActivity reportActivity);

    void inject(RedditViewImgurMediaActivity redditViewImgurMediaActivity);

    void inject(ViewImgurVideoFragment viewImgurVideoFragment);

    void inject(RedditDownloadRedditVideoService redditDownloadRedditVideoService);

    void inject(MultiRedditListingFragment multiRedditListingFragment);

    void inject(InboxFragment inboxFragment);

    void inject(RedditViewPrivateMessagesActivity redditViewPrivateMessagesActivity);

    void inject(SendPrivateMessageActivity sendPrivateMessageActivity);

    void inject(VideoPreferenceFragment videoPreferenceFragment);

    void inject(RedditViewRedditGalleryActivity redditViewRedditGalleryActivity);

    void inject(ViewRedditGalleryVideoFragment viewRedditGalleryVideoFragment);

    void inject(CustomizeMainPageTabsFragment customizeMainPageTabsFragment);

    void inject(RedditDownloadMediaService redditDownloadMediaService);

    void inject(DownloadLocationPreferenceFragment downloadLocationPreferenceFragment);

    void inject(RedditSubmitCrosspostActivity redditSubmitCrosspostActivity);

    void inject(FullMarkdownActivity fullMarkdownActivity);

    void inject(SelectUserFlairActivity selectUserFlairActivity);

    void inject(SecurityPreferenceFragment securityPreferenceFragment);

    void inject(NsfwAndSpoilerFragment nsfwAndSpoilerFragment);

    void inject(CustomizeBottomAppBarFragment customizeBottomAppBarFragment);

    void inject(GiveAwardActivity giveAwardActivity);

    void inject(TranslationFragment translationFragment);

    void inject(FetchRandomSubredditOrPostActivity fetchRandomSubredditOrPostActivity);

    void inject(MiscellaneousPreferenceFragment miscellaneousPreferenceFragment);

    void inject(CustomizePostFilterActivity customizePostFilterActivity);

    void inject(PostHistoryFragment postHistoryFragment);

    void inject(RedditPostFilterPreferenceActivity redditPostFilterPreferenceActivity);

    void inject(PostFilterUsageListingActivity postFilterUsageListingActivity);

    void inject(RedditSearchUsersResultActivity redditSearchUsersResultActivity);

    void inject(MultiredditSelectionActivity multiredditSelectionActivity);

    void inject(ViewImgurImageFragment viewImgurImageFragment);

    void inject(ViewRedditGalleryImageOrGifFragment viewRedditGalleryImageOrGifFragment);

    void inject(ViewPostDetailFragment viewPostDetailFragment);

    void inject(SuicidePreventionActivity suicidePreventionActivity);

    void inject(RedditWebViewActivity redditWebViewActivity);

    void inject(CrashReportsFragment crashReportsFragment);

    void inject(AnonymousSubscriptionsActivity anonymousSubscriptionsActivity);

    void inject(RedditLockScreenActivity redditLockScreenActivity);

    void inject(MaterialYouService materialYouService);

    void inject(RedditRPANActivity redditRpanActivity);

    void inject(ViewRPANBroadcastFragment viewRPANBroadcastFragment);

    void inject(RedditPostGalleryActivity redditPostGalleryActivity);

    void inject(RedditTrendingActivity redditTrendingActivity);
}
