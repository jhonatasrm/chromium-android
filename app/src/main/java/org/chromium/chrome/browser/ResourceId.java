package org.chromium.chrome.browser;
import org.chromium.chrome.R;
public class ResourceId {
    public static int mapToDrawableId(int enumeratedId) {
        int[] resourceList = {
0,
R.drawable.infobar_autofill_cc,
R.drawable.infobar_accessibility_events,
R.drawable.infobar_blocked_popups,
R.drawable.infobar_clipboard,
R.drawable.ic_folder_blue_24dp,
R.drawable.infobar_restore,
R.drawable.infobar_geolocation,
R.drawable.preview_pin_round,
R.drawable.infobar_camera,
R.drawable.infobar_microphone,
R.drawable.infobar_screen_share,
R.drawable.infobar_midi,
R.drawable.infobar_downloading,
R.drawable.infobar_desktop_notifications,
R.drawable.infobar_chrome,
R.drawable.infobar_protected_media_identifier,
R.drawable.ic_vpn_key_blue,
R.drawable.infobar_translate,
R.drawable.infobar_warning,
R.drawable.google_pay_with_divider,
R.drawable.pageinfo_good,
R.drawable.pageinfo_warning,
R.drawable.pageinfo_bad,
R.drawable.pageinfo_warning,
R.drawable.pageinfo_warning,
R.drawable.pageinfo_warning,
R.drawable.amex_card,
R.drawable.diners_card,
R.drawable.discover_card,
R.drawable.elo_card,
R.drawable.ic_credit_card_black,
R.drawable.jcb_card,
R.drawable.mc_card,
R.drawable.mir_card,
R.drawable.unionpay_card,
R.drawable.visa_card,
R.drawable.ic_photo_camera_black,
R.drawable.google_pay,
R.drawable.ic_info_outline_grey,
R.drawable.ic_warning_red,
R.drawable.ic_settings_black,
R.drawable.ic_edit_24dp,
R.drawable.cvc_icon,
R.drawable.cvc_icon_amex,
        };
        if (enumeratedId >= 0 && enumeratedId < resourceList.length) {
            return resourceList[enumeratedId];
        }
        assert false : "enumeratedId '" + enumeratedId + "' was out of range.";
        return R.drawable.missing;
    }
}
