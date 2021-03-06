/*
 * Copyright (C) 2013-2015 RoboVM AB
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 *   
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License. 
 * 
 * Portions of this code is based on Apple Inc's UICatalog sample (v11.3)
 * which is copyright (C) 2008-2015 Apple Inc.
 */
package org.robovm.samples.uicatalog.searchbar;

import org.robovm.apple.uikit.UIControlState;
import org.robovm.apple.uikit.UIImage;
import org.robovm.apple.uikit.UISearchBar;
import org.robovm.apple.uikit.UISearchBarDelegateAdapter;
import org.robovm.apple.uikit.UISearchBarIcon;
import org.robovm.apple.uikit.UIViewController;
import org.robovm.objc.annotation.CustomClass;
import org.robovm.objc.annotation.IBOutlet;
import org.robovm.samples.uicatalog.Colors;

@CustomClass("AAPLCustomSearchBarViewController")
public class AAPLCustomSearchBarViewController extends UIViewController {
    @IBOutlet
    private UISearchBar searchBar;

    @Override
    public void viewDidLoad() {
        super.viewDidLoad();

        configureSearchBar();
    }

    private void configureSearchBar() {
        searchBar.setDelegate(new UISearchBarDelegateAdapter() {
            @Override
            public void searchButtonClicked(UISearchBar searchBar) {
                System.out.println(String.format("The custom search bar keyboard search button was tapped: %s.",
                        searchBar.getText()));

                searchBar.resignFirstResponder();
            }

            @Override
            public void cancelButtonClicked(UISearchBar searchBar) {
                System.out.println("The custom search bar cancel button was tapped.");

                searchBar.resignFirstResponder();
            }

            @Override
            public void bookmarkButtonClicked(UISearchBar searchBar) {
                System.out.println("The custom bookmark button inside the search bar was tapped.");
            }
        });

        searchBar.setShowsCancelButton(true);
        searchBar.setShowsBookmarkButton(true);

        searchBar.setTintColor(Colors.PURPLE);

        searchBar.setBackgroundImage(UIImage.getImage("search_bar_background"));

        // Set the bookmark image for both normal and highlighted states.
        UIImage bookmarkImage = UIImage.getImage("bookmark_icon");
        searchBar.setImageForSearchBarIcon(bookmarkImage, UISearchBarIcon.Bookmark, UIControlState.Normal);

        UIImage bookmarkHighlightedImage = UIImage.getImage("bookmark_icon_highlighted");
        searchBar.setImageForSearchBarIcon(bookmarkHighlightedImage, UISearchBarIcon.Bookmark,
                UIControlState.Highlighted);
    }
}
