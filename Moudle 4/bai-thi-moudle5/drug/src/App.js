// import './App.css';

import React, { useState, useEffect } from "react";

import ProductList from "./components/ProductList";
import ProductAdd from "./components/ProductAdd";
import { fetchProducts, fetchCategories } from "./api";
import './components/App.css';  // Import file CSS


const App = () => {
  const [products, setProducts] = useState([]);
  const [categories, setCategories] = useState([]);
  const [searchQuery, setSearchQuery] = useState("");
  const [selectedCategory, setSelectedCategory] = useState("");
  const [showAddForm, setShowAddForm] = useState(false);

  useEffect(() => {
    const loadProducts = async () => {
      const data = await fetchProducts();
      setProducts(data);
    };
    loadProducts();
  }, []);

  useEffect(() => {
    const loadCategories = async () => {
      const data = await fetchCategories();
      setCategories(data);
    };
    loadCategories();
  }, []);

  const handleSearch = () => {
    let filteredProducts = products;
    if (searchQuery) {
      filteredProducts = filteredProducts.filter((product) =>
          product.name.toLowerCase()(searchQuery.toLowerCase()) ||
          product.category.toLowerCase()(searchQuery.toLowerCase())
      );
    }

    return filteredProducts;
  };

  const handleShowAddForm = () => setShowAddForm(true);
  const handleHideAddForm = () => setShowAddForm(false);
  const handleAddProductSuccess = async () => {
    const updatedProducts = await fetchProducts();
    setProducts(updatedProducts);
    setShowAddForm(false);
  };

  return (
      <div>
        <h1>Quản lý sản phẩm thuốc</h1>

        <div style={{ display: "flex", justifyContent: "space-between", marginBottom: "20px" }}>
          <input
              type="text"
              placeholder="Tìm kiếm sản phẩm hoặc thể loại..."
              value={searchQuery}
              onChange={(e) => setSearchQuery(e.target.value)}
              style={{ width: "300px", padding: "8px" }}
          />
          <select
              value={selectedCategory}
              onChange={(e) => setSelectedCategory(e.target.value)}
              style={{ padding: "8px", width: "200px" }}
          >
            <option value="">Chọn thể loại</option>
            {categories.map((category) => (
                <option key={category.id} value={category.name}>
                  {category.name}
                </option>
            ))}
          </select>
        </div>

        {showAddForm ? (
            <div>
              <ProductAdd onAddSuccess={handleAddProductSuccess} />
              <button onClick={handleHideAddForm}>Quay lại danh sách</button>
            </div>
        ) : (
            <div>
              <button onClick={handleShowAddForm}>Thêm sản phẩm mới</button>
              <ProductList products={handleSearch()} />
            </div>
        )}
      </div>
  );
};

export default App;
