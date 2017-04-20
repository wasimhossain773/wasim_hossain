/**
* Android ownCloud News
*
* @author David Luhmer
* @copyright 2013 David Luhmer david-dev@live.de
*
* This library is free software; you can redistribute it and/or
* modify it under the terms of the GNU AFFERO GENERAL PUBLIC LICENSE
* License as published by the Free Software Foundation; either
* version 3 of the License, or any later version.
*
* This library is distributed in the hope that it will be useful,
* but WITHOUT ANY WARRANTY; without even the implied warranty of
* MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
* GNU AFFERO GENERAL PUBLIC LICENSE for more details.
*
* You should have received a copy of the GNU Affero General Public
* License along with this library.  If not, see <http://www.gnu.org/licenses/>.
*
*/

package de.luhmer.owncloudnewsreader.helper;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import de.luhmer.owncloudnewsreader.R;
import de.luhmer.owncloudnewsreader.SettingsActivity;

public class ThemeChooser {

	public static void chooseTheme(Activity act)
	{
        if(isDarkTheme(act)) {
            act.setTheme(R.style.AppTheme);
        } else {
            act.setTheme(R.style.AppThemeLight);
        }
	}


    public static boolean ThemeRequiresRestartOfUI(Context context) {
        return mIsDarkTheme != null && mIsDarkTheme != isDarkTheme(context, true);
    }

    static Boolean mIsDarkTheme;
	public static boolean isDarkTheme(Context context)
	{
        return isDarkTheme(context, false);
	}

    public static boolean isDarkTheme(Context context, boolean forceReloadCache) {
        if(mIsDarkTheme == null || forceReloadCache) {
            SharedPreferences mPrefs = PreferenceManager.getDefaultSharedPreferences(context);
            String value = mPrefs.getString(SettingsActivity.SP_APP_THEME, "0");
            mIsDarkTheme = value.equals("0");
        }
        return mIsDarkTheme;
    }
}
