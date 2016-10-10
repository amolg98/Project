					<div>
		                    <ul class="menu">
	                        <li onmouseover="hideallimmenu()"><a href="/Project/JspPages/Home.jsp" class="nav">Home </a></li>
	                        <li onmouseover="showrewardsubmenu()"><a href="#" class="nav_even">Model</a></li>
	                        <li onmouseover="showrewardsubmenu1()"><a href="#" class="nav">Product</a></li>
	                        <li onmouseover="showrewardsubmenu2()"><a href="#" class="nav_even">View</a></li>
	                        <li onmouseover="hideallimmenu()"><a href="/Project/InventoryController?action=logout" class="nav">Logout</a></li>
	                    </ul>
	                </div>
	                	<div id="rewardsubmenu">
		               		<table bgcolor="#133457" >		               		    
		               			<tr><td onclick="hideallimmenu()"><a href="/Project/InventoryController?action=addModelPage" class="nav_even">Add Model</a></td></tr>
		               			<tr><td onclick="hideallimmenu()"><a href="/Project/InventoryController?action=updateModelList" class="nav_even">Update/Delete Model</a></td></tr>
		               			<tr><td onclick="hideallimmenu()"><a href="/Project/InventoryController?action=tagModel" class="nav_even">Tag Model(s)</a></td></tr>
		                    </table>
	                	</div>
	                	<div id="rewardsubmenu1">
		               		<table bgcolor="#133457">		               		    
		               			<tr><td onclick="hideallimmenu()" colspan="10"><a href="/Project/InventoryController?action=addProductModel" class="nav_even">Add Product</a></td></tr>
		               			<tr><td onclick="hideallimmenu()"><a href="/Project/JspPages/deleteProducts.jsp" class="nav_even">Delete Product</a></td></tr>
		               			<tr><td onclick="hideallimmenu()"><a href="/Project/InventoryController?action=updateStatus" class="nav_even">Dispatch Products</a></td></tr>
		               			<tr><td onclick="hideallimmenu()"><a href="/Project/InventoryController?action=ReplaceProduct" class="nav_even">Replace Defected Products</a></td></tr>
		                    </table>
	                	</div>
	                	<div id="rewardsubmenu2">
		               		<table bgcolor="#133457">		               		    
		               			<tr><td onclick="hideallimmenu()" colspan="10"><a href="/Project/InventoryController?action=viewStock" class="nav_even">View Stock</a></td></tr>
		               			<tr><td onclick="hideallimmenu()"><a href="/Project/InventoryController?action=tag" class="nav_even">View Tagged Models</a></td></tr>
		               			<tr><td onclick="hideallimmenu()"><a href="/Project/InventoryController?action=viewModel" class="nav_even">View Models</a></td></tr>
		               			<tr><td onclick="hideallimmenu()"><a href="/Project/JspPages/ViewProductbyModel.jsp" class="nav_even">View Products</a></td></tr>
		               			<tr><td onclick="hideallimmenu()"><a href="/Project/JspPages/SearchCatalog.jsp" class="nav_even">Search</a></td></tr>
		                    </table>
	                	</div>
	                	
	                	
	                	

	
	              