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

package de.luhmer.owncloudnewsreader.reader;

public enum FeedItemTags {
	MARK_ITEM_AS_READ("read"),
	MARK_ITEM_AS_UNREAD("unread"),
	MARK_ITEM_AS_STARRED("star"),
	MARK_ITEM_AS_UNSTARRED("unstar"),
	ALL_STARRED("2"),
	ALL("3");

	private String segment;

	FeedItemTags(String segment) {
		this.segment = segment;
	}

	@Override
	public String toString() {
		return this.segment;
	}
}
