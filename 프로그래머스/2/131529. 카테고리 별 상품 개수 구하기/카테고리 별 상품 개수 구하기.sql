SELECT SUBSTRING(PRODUCT_CODE, 1, 2) as CATEGORY, COUNT(PRODUCT_CODE) as PRODUCTS
from PRODUCT
group by 1
order by 1;