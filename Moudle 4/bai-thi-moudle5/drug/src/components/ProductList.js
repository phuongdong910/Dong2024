import React from "react";
import './App.css';  // Import file CSS vào đây


const ProductList = ({ products }) => {
    return (
        <div>
            {products.length === 0 ? (
                <p className="thong-bao-loi">Nhà thuốc hết loại này rồi bạn ơi ^^</p>
            ) : (
                <table className='product-table'>
                    <thead>
                    <tr>
                        <th>STT</th>
                        <th>Mã sản phẩm</th>
                        <th>Tên sản phẩm</th>
                        <th>Thể loại</th>
                        <th>Số lượng</th>
                        <th>Giá</th>
                        <th>Ngày nhập</th>
                    </tr>
                    </thead>
                    <tbody>
                    {products.map((product, index) => (
                        <tr key={product.id}>
                            <td>{index + 1}</td>
                            <td>{product.code}</td>
                            <td>{product.name}</td>
                            <td>{product.category}</td>
                            <td>{product.quantity}</td>
                            <td>{product.price}</td>
                            <td>{product.importDate}</td>
                        </tr>
                    ))}
                    </tbody>
                </table>
            )}
        </div>
    );
};

export default ProductList;
